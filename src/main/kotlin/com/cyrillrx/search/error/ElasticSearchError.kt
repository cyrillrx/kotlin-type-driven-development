package com.cyrillrx.search.error

import com.cyrillrx.search.data.ESResponse

sealed interface ElasticSearchError : SearchServiceError {
    class Unknown : ElasticSearchError
    class ConnectionError : ElasticSearchError
    class InvalidQuery : ElasticSearchError
    class UnableToParseEsResponse(val esResponse: ESResponse) : ElasticSearchError
}