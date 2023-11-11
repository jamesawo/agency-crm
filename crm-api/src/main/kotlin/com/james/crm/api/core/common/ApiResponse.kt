/*
 * @Author: james.aworo
 * @Date: 11/11/23
 *
 * @Project: agent-crm
 */

package com.james.crm.api.core.common

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
