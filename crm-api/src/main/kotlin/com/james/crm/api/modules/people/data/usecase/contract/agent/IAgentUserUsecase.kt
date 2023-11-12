/*
 * @Author: james.aworo
 * @Date: 11/8/23
 *
 * @Project: agent-crm
 */

package com.james.crm.api.modules.people.data.usecase.contract.agent

import com.james.crm.api.core.common.ApiResponse
import com.james.crm.api.modules.people.data.dto.UserDto
import org.springframework.http.ResponseEntity

interface IAgentUserUsecase {
    fun getUser(agentId: String): ResponseEntity<ApiResponse<UserDto>>
    fun updateUser(agentId: String, userDto: UserDto): ResponseEntity<ApiResponse<UserDto>>
}