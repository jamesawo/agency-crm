/*
 * @Author: james.aworo
 * @Date: 11/11/23
 *
 * @Project: agent-crm
 */

package com.james.crm.api.core.common

import com.james.crm.api.core.annotation.Usecase
import org.springframework.http.ResponseEntity

@Usecase
interface Usecase<Input, Output> {
    fun execute(input: Input): ResponseEntity<ApiResponse<Output>>
}