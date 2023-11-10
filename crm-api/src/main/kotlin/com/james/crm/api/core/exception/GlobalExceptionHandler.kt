/*
 * @Author: james.aworo
 * @Date: 11/10/23
 *
 * @Project: agent-crm
 */

package com.james.crm.api.core.exception

import com.fasterxml.jackson.databind.JsonMappingException
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.http.converter.HttpMessageNotReadableException
import org.springframework.validation.FieldError
import org.springframework.web.bind.MethodArgumentNotValidException
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestControllerAdvice

@RestControllerAdvice
class GlobalExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException::class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    fun handleValidationExceptions(ex: MethodArgumentNotValidException): ResponseEntity<Map<String, String>> {
        val resolve = mutableMapOf<String, String>()
        ex.bindingResult.allErrors.forEach { error ->
            if (error is FieldError) {
                resolve[error.field] = error.defaultMessage ?: "failed validation"
            } else {
                resolve[error.objectName] = error.defaultMessage ?: "failed validation"
            }
        }
        return ResponseEntity.badRequest().body(resolve)
    }

    @ExceptionHandler(HttpMessageNotReadableException::class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    fun handleHttpMessageNotReadableException(ex: HttpMessageNotReadableException): ResponseEntity<String> {
        if (ex.cause is JsonMappingException) {
            val jsonMappingException = ex.cause as JsonMappingException
            val fieldName = jsonMappingException.path.joinToString(".") { it.fieldName }
            val errorMessage = "Invalid value or format for field: '$fieldName'."
            return ResponseEntity.badRequest().body(errorMessage)
        }

        // Default error message if the cause is not a JsonMappingException
        val defaultErrorMessage = "Malformed JSON request or invalid request body format."
        return ResponseEntity.badRequest().body(defaultErrorMessage)
    }
}