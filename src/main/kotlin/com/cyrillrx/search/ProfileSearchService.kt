package com.cyrillrx.search

import com.cyrillrx.search.criteria.ProfileSearchCriteria
import com.cyrillrx.search.data.ESDataSource
import com.cyrillrx.search.data.ESDocument
import com.cyrillrx.search.data.ESQueryFactory
import com.cyrillrx.search.data.ESResponse
import com.cyrillrx.search.error.ElasticSearchError
import com.cyrillrx.search.error.SearchServiceError

class ProfileSearchService(
    val esQueryFactory: ESQueryFactory,
    val esDataSource: ESDataSource,
) {
    fun search(criteria: ProfileSearchCriteria): Result<List<Profile>, SearchServiceError> {
        val esQuery = esQueryFactory.create(criteria)
        val esResponse = esDataSource.search(esQuery)
        return esResponse.toProfiles()
    }

    private fun ESResponse.toProfiles(): Result<List<Profile>, ElasticSearchError> {
        return try {
            val profiles = documents.mapNotNull { it.toProfile() }
            Result.Success(profiles)
        } catch (e: Exception) {
            Result.Failure(ElasticSearchError.UnableToParseEsResponse(this))
        }
    }

    private fun ESDocument.toProfile(): Profile? {
        // TODO Track parsing failures count and reasons
        val id = this["id"]?.toIntOrNull() ?: return null
        val name = this["name"] ?: return null
        val photoUrl = this["photoUrl"] ?: return null

        return Profile(id, name, photoUrl)
    }
}

