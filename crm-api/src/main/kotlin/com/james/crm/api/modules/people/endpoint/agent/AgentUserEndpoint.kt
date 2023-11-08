/*
 * @Author: james.aworo
 * @Date: 11/8/23
 *
 * @Project: agent-crm
 */

package com.james.crm.api.modules.people.endpoint.agent

import com.james.crm.api.core.constant.Route
import com.james.crm.api.modules.people.data.dto.UserDto
import com.james.crm.api.modules.people.data.usecase.contract.agent.IAgentUserUsecase
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("${Route.BASE}/agents/{agentId}/user")
class AgentUserEndpoint(
    private val userUsecase: IAgentUserUsecase
) {
    // Users
    @GetMapping("/{id}/user")
    fun getUser(@PathVariable id: String, @PathVariable agentId: String): ResponseEntity<UserDto> {
        return userUsecase.getUser(id)
    }

    @PutMapping("/{id}/user")
    fun updateUser(
        @PathVariable id: String,
        @RequestBody userDto: UserDto,
        @PathVariable agentId: String
    ): ResponseEntity<UserDto> {
        return userUsecase.updateUser(id, userDto)
    }

}