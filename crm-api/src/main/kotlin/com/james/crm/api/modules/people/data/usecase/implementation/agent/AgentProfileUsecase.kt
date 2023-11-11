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
import com.james.crm.api.modules.people.domain.repository.AgentDataRepository
import org.springframework.http.ResponseEntity

@Usecase
class AgentProfileUsecase(
    private val repository: AgentDataRepository,
) : IAgentProfileUsecase {
    override fun getProfile(agentId: String): ResponseEntity<ProfileDto> {
        return repository.findById(agentId).map {
            ResponseEntity.ok(ProfileDto.toTrimmedRequest(it.profile))
        }.orElse(ResponseEntity.notFound().build())
    }

    override fun updateProfile(agentId: String, profileDto: ProfileDto): ResponseEntity<ProfileDto> {
        return repository.findById(agentId).map {
            it.profile = ProfileDto.toEntity(profileDto.apply { id = it.profile.id })
            ResponseEntity.ok(ProfileDto.toTrimmedRequest(repository.save(it).profile))
        }.orElse(ResponseEntity.notFound().build())
    }
}