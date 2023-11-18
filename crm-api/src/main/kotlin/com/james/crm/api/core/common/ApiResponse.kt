/*
 * @Author: james.aworo
 * @Date: 11/11/23
 *
 * @Project: agent-crm
 */

package com.james.crm.api.core.common

import com.fasterxml.jackson.annotation.JsonIgnore
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.http.HttpStatus

sealed class ApiResponse<out T>(
    open val message: String?,
    open val status: Int
)

data class SuccessResponse<out T>(
    override val message: String?,
    override val status: Int,
    val data: T
) : ApiResponse<T>(message, status) {
    constructor(status: HttpStatus, data: T) : this(
        status = status.value(),
        message = status.reasonPhrase,
        data = data
    )
}

data class ErrorResponse(
    override val message: String?,
    override val status: Int,
    val errors: List<String>
) : ApiResponse<Nothing>(message, status) {
    constructor(status: HttpStatus, errors: List<String>) : this(
        status = status.value(),
        message = status.reasonPhrase,
        errors = errors
    )
}

data class CatchableError(
    override val message: String?,
    override val status: Int,
    val errors: List<String>,
    @JsonIgnore
    val exception: Throwable? = null
) : ApiResponse<Nothing>(message, status) {
    constructor(status: HttpStatus, errors: List<String>, exception: Throwable? = null) : this(
        status = status.value(),
        message = status.reasonPhrase,
        errors = errors,
        exception = exception
    )

    constructor(status: HttpStatus, exception: Throwable) : this(
        status = status.value(),
        message = status.reasonPhrase,
        errors = listOf(exception.localizedMessage),
        exception = exception
    )

    init {
        log()
    }

    private fun log(logger: Logger = LoggerFactory.getLogger(this.javaClass)) {
        logger.error("notify logger service: Status=$status, Errors=$errors, $message ${exception?.localizedMessage} ")
        // if (exception != null) throw exception
    }
}
