/*
 * @Author: james.aworo
 * @Date: 11/8/23
 *
 * @Project: agent-crm
 */

package com.james.crm.api.modules.people.data.usecase.implementation.agent

import com.james.crm.api.core.annotation.Usecase
import com.james.crm.api.modules.people.data.dto.UserDto
import com.james.crm.api.modules.people.data.usecase.contract.agent.IAgentUserUsecase
import org.springframework.http.ResponseEntity

@Usecase
class AgentUserUsecase : IAgentUserUsecase {
    override fun getUser(agentId: String): ResponseEntity<UserDto> {
        TODO()
    }

    override fun updateUser(agentId: String, userDto: UserDto): ResponseEntity<UserDto> {
        TODO()
    }
}