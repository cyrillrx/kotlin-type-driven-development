package com.cyrillrx.search

import com.cyrillrx.search.criteria.ProfileSearchCriteria
import com.cyrillrx.search.error.SearchCriteriaCreationError

interface SearchCriteriaFactory {
    fun create() : Result<ProfileSearchCriteria, SearchCriteriaCreationError>
}