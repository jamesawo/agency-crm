/*
 * @Author: james.aworo
 * @Date: 11/12/23
 *
 * @Project: agent-crm
 */

package com.james.crm.api.core.util

import com.james.crm.api.core.common.ApiResponse
import com.james.crm.api.core.common.ErrorResponse
import com.james.crm.api.core.common.SuccessResponse
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity

class Util {
    companion object {

        fun <T> toSuccess(status: HttpStatus, data: T): ResponseEntity<ApiResponse<T>> {
            return ResponseEntity.status(status).body(SuccessResponse(status, data) as ApiResponse<T>)
        }

        fun <T> toError(status: HttpStatus, errors: List<String>): ResponseEntity<ApiResponse<T>> {
            return ResponseEntity.status(status).body(ErrorResponse(status, errors) as ApiResponse<T>)
        }

        private fun normalizeErrorMessages(messages: Any): List<String> {
            return when (messages) {
                is String -> listOf(messages)
                is List<*> -> messages.filterIsInstance<String>()
                else -> emptyList()
            }
        }

        fun notFoundMessage(modelName: String): String {
            val messages = listOf(
                "Oops! It seems like the ${modelName.lowercase()} has gone missing.",
                "Uh-oh! We couldn't find the requested ${modelName.lowercase()}.",
                "Sorry, but the ${modelName.lowercase()} you're looking for is not in our records.",
                "Looks like the ${modelName.lowercase()} has vanished. Please check the details and try again.",
                "The ${modelName.lowercase()} you're searching for seems to be playing hide and seek. Can you double-check the information?"
            )
            return messages.random()
        }

        fun notFoundMessageList(modelName: String): List<String> {
            return normalizeErrorMessages(notFoundMessage(modelName))
        }
    }
}