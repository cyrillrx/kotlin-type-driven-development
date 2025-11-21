package com.cyrillrx.search.error

sealed interface SearchCriteriaCreationError : SearchServiceError {
    class Unknown : SearchCriteriaCreationError
    class InvalidParameters : SearchCriteriaCreationError
}