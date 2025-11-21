package com.cyrillrx.search

import com.cyrillrx.search.criteria.Hobby
import com.cyrillrx.search.criteria.ProfileSearchCriteria
import com.cyrillrx.search.data.ESDataSource
import com.cyrillrx.search.data.ESQuery
import com.cyrillrx.search.data.ESResponse
import com.cyrillrx.search.error.ElasticSearchError
import com.cyrillrx.search.error.SearchCriteriaCreationError
import com.cyrillrx.search.error.SearchServiceError
import kotlin.test.Test

class ProfileSearchServiceTest {

    class DummyESDataSource : ESDataSource {
        override fun search(query: ESQuery): ESResponse {
            val profile1 = mapOf(
                "id" to "1",
                "name" to "John Doe",
                "hobbies" to "Coffee, Beer",
                "age" to "30",
                "photoUrl" to "photo_url",
            )
            val profile2 = mapOf(
                "id" to "2",
                "name" to "Jane Doe",
                "hobbies" to "Japan, Healthy",
                "age" to "30",
                "photoUrl" to "photo_url",
            )
            val profiles = listOf(profile1, profile2)
            return ESResponse(profiles)
        }
    }

    val esDataSource = DummyESDataSource()

    // TODO invalid document response
    // TODO search throws
    // TODO Empty with parsing errors
    // TODO Empty result

    @Test
    fun testSearch() {
        val criteria = ProfileSearchCriteria.HobbyBased(Hobby.COFFEE, 10)
        val service = ProfileSearchService(esDataSource)
        val result = service.search(criteria)
        when (result) {
            is Result.Failure -> handleFailure(result.error)
            is Result.Success -> {
                // I don't care about success ¯\_(ツ)_/¯
            }
        }
    }

    private fun handleFailure(error: SearchServiceError) {
        when (error) {
            is SearchServiceError.Unknown -> TODO()
            is ElasticSearchError.Unknown -> TODO()
            is ElasticSearchError.EmptyWithParsingErrors -> TODO()
            is ElasticSearchError.NoProfilesFound -> TODO()
            is SearchCriteriaCreationError.Unknown -> TODO()
            is SearchCriteriaCreationError.InvalidParameters -> TODO()
        }
    }
}