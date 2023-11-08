/*
 * @Author: james.aworo
 * @Date: 11/8/23
 *
 * @Project: agent-crm
 */

package com.james.crm.api.modules.people.data.usecase.implementation.agent

import com.james.crm.api.core.annotation.Usecase
import com.james.crm.api.modules.people.data.dto.ProfileDto
import com.james.crm.api.modules.people.data.usecase.contract.agent.IAgentProfileUsecase
import org.springframework.http.ResponseEntity

@Usecase
class AgentProfileUsecase : IAgentProfileUsecase {
    override fun getProfile(agentId: String): ResponseEntity<ProfileDto> {
        TODO("Implementation to get a Profile")
    }

    override fun updateProfile(agentId: String, profileDto: ProfileDto): ResponseEntity<ProfileDto> {
        TODO("Implementation to update a Profile")
    }
}