/*
 * @Author: james.aworo
 * @Date: 11/11/23
 *
 * @Project: agent-crm
 */

package com.james.crm.api.core.model

import org.springframework.http.ResponseEntity

interface Usecase<Input, Output> {
    fun execute(input: Input): ResponseEntity<Output>
}