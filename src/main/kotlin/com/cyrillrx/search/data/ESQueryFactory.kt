package com.cyrillrx.search.data

import com.cyrillrx.search.criteria.ProfileSearchCriteria

// No Result handling here because input is compliant by typing
interface ESQueryFactory {

    fun create(criteria: ProfileSearchCriteria): ESQuery {
        val parameters = when (criteria) {
            is ProfileSearchCriteria.Timeline -> criteria.toESQuery()
            is ProfileSearchCriteria.HobbyBased -> criteria.toESQuery()
        }

        return ESQuery(parameters)
    }

    private fun ProfileSearchCriteria.Timeline.toESQuery(): Map<String, Any> {
        return mapOf(
            "distanceKm" to distanceKm.toString(),
        )
    }

    private fun ProfileSearchCriteria.HobbyBased.toESQuery(): Map<String, Any> {
        return mapOf(
            "distanceKm" to distanceKm.toString(),
            "hobby" to hobby.name,
        )
    }
}