/*
 * @Author: james.aworo
 * @Date: 11/11/23
 *
 * @Project: agent-crm
 */

package com.james.crm.api.core.common


sealed class ApiResponse<T>(
    open val message: String?,
    open val status: Int
)

data class SuccessApiResponse<T>(
    override val message: String?,
    override val status: Int,
    val data: T
) : ApiResponse<T>(message, status)

data class ErrorApiResponse(
    override val message: String?,
    override val status: Int,
    val errors: List<String>
) : ApiResponse<Nothing>(message, status)
