/*
 * @Author: james.aworo
 * @Date: 11/10/23
 *
 * @Project: agent-crm
 */

package com.james.crm.api.core.exception

import com.fasterxml.jackson.databind.JsonMappingException
import com.james.crm.api.core.common.ApiResponse
import com.james.crm.api.core.common.ErrorResponse
import org.springframework.http.HttpStatus
import org.springframework.http.HttpStatus.BAD_REQUEST
import org.springframework.http.HttpStatus.METHOD_NOT_ALLOWED
import org.springframework.http.ResponseEntity
import org.springframework.http.converter.HttpMessageNotReadableException
import org.springframework.validation.FieldError
import org.springframework.web.HttpRequestMethodNotSupportedException
import org.springframework.web.bind.MethodArgumentNotValidException
import org.springframework.web.bind.MissingServletRequestParameterException
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestControllerAdvice
import java.util.*


@RestControllerAdvice
class GlobalExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException::class)
    @ResponseStatus(BAD_REQUEST)
    fun handleValidationExceptions(ex: MethodArgumentNotValidException): ResponseEntity<ApiResponse<Nothing>> {
        val resolve = mutableMapOf<String, String>()
        ex.bindingResult.allErrors.forEach { error ->
            if (error is FieldError) {
                resolve[error.field] = error.defaultMessage ?: "failed validation"
            } else {
                resolve[error.objectName] = error.defaultMessage ?: "failed validation"
            }
        }
        val response: ApiResponse<Nothing> = ErrorResponse(
            message = BAD_REQUEST.reasonPhrase,
            status = BAD_REQUEST.value(),
            errors = resolve.map { entry: Map.Entry<String, String> -> "${entry.key} -> ${entry.value}" }
        )
        return ResponseEntity.badRequest().body(response)
    }

    @ExceptionHandler(HttpMessageNotReadableException::class)
    @ResponseStatus(BAD_REQUEST)
    fun handleHttpMessageNotReadableException(ex: HttpMessageNotReadableException): ResponseEntity<ErrorResponse> {
        if (ex.cause is JsonMappingException) {
            val jsonMappingException = ex.cause as JsonMappingException
            val fieldName = jsonMappingException.path.joinToString(".") { it.fieldName }
            val errorMessage = "Invalid value or format for field: '$fieldName'."

            val response = ErrorResponse(
                message = BAD_REQUEST.reasonPhrase,
                status = BAD_REQUEST.value(), errors = listOf(errorMessage)
            )
            return ResponseEntity.status(BAD_REQUEST).body(response)
        }

        // Default error message if the cause is not a JsonMappingException
        val defaultErrorMessage = "Malformed JSON request or invalid request body format."
        val response = ErrorResponse(
            message = BAD_REQUEST.reasonPhrase,
            status = BAD_REQUEST.value(),
            errors = listOf(defaultErrorMessage)
        )
        return ResponseEntity.badRequest().body(response)
    }

    @ExceptionHandler(HttpRequestMethodNotSupportedException::class)
    fun handleError(e: HttpRequestMethodNotSupportedException): ResponseEntity<ErrorResponse> {
        val apiErrorResponse = ErrorResponse(
            message = METHOD_NOT_ALLOWED.reasonPhrase,
            status = METHOD_NOT_ALLOWED.value(),
            errors = listOf("It seems you're using the wrong HTTP method: ${e.message}")
        )
        return ResponseEntity.status(METHOD_NOT_ALLOWED).body(apiErrorResponse)
    }


    @ExceptionHandler(MissingServletRequestParameterException::class)
    @ResponseStatus(BAD_REQUEST)
    fun handleMissingServletRequestParameterException(
        ex: MissingServletRequestParameterException
    ): ResponseEntity<ErrorResponse> {
        val apiErrorResponse = ErrorResponse(
            message = BAD_REQUEST.reasonPhrase,
            status = BAD_REQUEST.value(),
            errors = listOf("Parameter '${ex.parameterName}' is missing")
        )
        return ResponseEntity.status(BAD_REQUEST).body(apiErrorResponse)
    }

    @ExceptionHandler(Exception::class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    fun handleGenericException(
        ex: Exception
    ): ResponseEntity<ErrorResponse> {
        val response = ErrorResponse(
            message = HttpStatus.INTERNAL_SERVER_ERROR.reasonPhrase,
            status = HttpStatus.INTERNAL_SERVER_ERROR.value(),
            errors = listOf("An unexpected error occurred: ${ex.message}")
        )
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response)
    }
}