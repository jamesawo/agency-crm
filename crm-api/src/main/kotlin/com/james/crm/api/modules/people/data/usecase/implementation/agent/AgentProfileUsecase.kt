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
import com.james.crm.api.modules.people.data.usecase.contract.agent.IAgentUsecase
import com.james.crm.api.modules.people.domain.repository.AgentDataRepository
import org.springframework.http.ResponseEntity

@Usecase
class AgentProfileUsecase(
    private val repository: AgentDataRepository,
    private val usecase: IAgentUsecase
) : IAgentProfileUsecase {
    override fun getProfile(agentId: String): ResponseEntity<ProfileDto> {
        return repository.findById(agentId).map {
            ResponseEntity.ok(ProfileDto.toTrimmedRequest(it.profile))
        }.orElse(ResponseEntity.notFound().build())
    }

    override fun updateProfile(agentId: String, profileDto: ProfileDto): ResponseEntity<ProfileDto> {
        val optionalAgent = repository.findById(agentId)
        return optionalAgent.map {
            it.profile = ProfileDto.toEntity(profileDto)
            val agent = repository.save(it)
            ResponseEntity.ok(ProfileDto.toTrimmedRequest(agent.profile))
        }.orElse(ResponseEntity.notFound().build())
    }
}