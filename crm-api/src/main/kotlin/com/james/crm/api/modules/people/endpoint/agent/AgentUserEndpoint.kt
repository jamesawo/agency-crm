/*
 * @Author: james.aworo
 * @Date: 11/8/23
 *
 * @Project: agent-crm
 */

package com.james.crm.api.modules.people.endpoint.agent

import com.james.crm.api.core.common.ApiResponse
import com.james.crm.api.core.constant.Route
import com.james.crm.api.modules.people.data.dto.UserDto
import com.james.crm.api.modules.people.data.usecase.contract.agent.IAgentUserUsecase
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("${Route.API_VERSION}/agents/{agentId}/user")
class AgentUserEndpoint(
    private val userUsecase: IAgentUserUsecase
) {
    @GetMapping
    fun getUser(
        @PathVariable agentId: String
    ): ResponseEntity<ApiResponse<UserDto>> {
        return userUsecase.getUser(agentId)
    }

    @PutMapping
    fun updateUser(
        @RequestBody userDto: UserDto,
        @PathVariable agentId: String
    ): ResponseEntity<ApiResponse<UserDto>> {
        return userUsecase.updateUser(agentId, userDto)
    }

}