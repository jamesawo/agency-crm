/*
 * @Author: james.aworo
 * @Date: 11/12/23
 *
 * @Project: agent-crm
 */

package com.james.crm.api.core.util

import com.james.crm.api.core.common.ApiResponse
import com.james.crm.api.core.common.CatchableError
import com.james.crm.api.core.common.ErrorResponse
import com.james.crm.api.core.common.SuccessResponse
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity

class Util {
    companion object {

        fun <T> successResponse(status: HttpStatus, data: T): ResponseEntity<ApiResponse<T>> {
            return ResponseEntity.status(status).body(SuccessResponse(status, data) as ApiResponse<T>)
        }

        fun <T> errorResponse(status: HttpStatus, errors: List<String>): ResponseEntity<ApiResponse<T>> {
            return ResponseEntity.status(status).body(ErrorResponse(status, errors) as ApiResponse<T>)
        }

        fun <T> errorResponse(
            status: HttpStatus,
            error: CatchableError
        ): ResponseEntity<ApiResponse<T>> {
            return ResponseEntity.status(status).body(error as ApiResponse<T>)
        }

        fun notFoundMessageAsList(modelName: String): List<String> {
            return normalizeErrorMessages(notFoundMessage(modelName))
        }

        private fun normalizeErrorMessages(messages: Any): List<String> {
            return when (messages) {
                is String -> listOf(messages)
                is List<*> -> messages.filterIsInstance<String>()
                else -> emptyList()
            }
        }

        private fun notFoundMessage(modelName: String): String {
            val messages = listOf(
                "Oops! It seems like the ${modelName.lowercase()} has gone missing.",
                "Uh-oh! We couldn't find the requested ${modelName.lowercase()}.",
                "Sorry, but the ${modelName.lowercase()} you're looking for is not in our records.",
                "Looks like the ${modelName.lowercase()} has vanished. Please check the details and try again.",
                "The ${modelName.lowercase()} you're searching for seems to be playing hide and seek. Can you double-check the information?"
            )
            return messages.random()
        }
    }
}