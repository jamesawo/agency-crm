/*
 * @Author: james.aworo
 * @Date: 11/10/23
 *
 * @Project: agent-crm
 */

package com.james.crm.api.core.exception

import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
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
}