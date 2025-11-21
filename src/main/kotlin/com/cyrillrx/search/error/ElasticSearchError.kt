package com.cyrillrx.search.error

sealed interface ElasticSearchError : SearchServiceError {
    object Unknown : ElasticSearchError
    object NoProfilesFound : ElasticSearchError
    object EmptyWithParsingErrors : ElasticSearchError
}
