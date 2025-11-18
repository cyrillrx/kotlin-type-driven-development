package com.cyrillrx.upload.strongtyping.withresult.error

sealed interface Result<out Data, out E : DomainError> {
    data class Success<out Data>(val value: Data) : Result<Data, Nothing>
    data class Failure<out E : DomainError>(val error: E) : Result<Nothing, E>
}
