/*
 * @Author: james.aworo
 * @Date: 11/8/23
 *
 * @Project: agent-crm
 */

package com.james.crm.api.modules.people.data.usecase.implementation.agent

import com.james.crm.api.core.annotation.Usecase
import com.james.crm.api.core.common.ApiResponse
import com.james.crm.api.core.util.Util.Companion.errorResponse
import com.james.crm.api.core.util.Util.Companion.notFoundMessageAsList
import com.james.crm.api.core.util.Util.Companion.successResponse
import com.james.crm.api.modules.people.data.dto.other.ProfileDto
import com.james.crm.api.modules.people.data.usecase.contract.agent.IAgentProfileUsecase
import com.james.crm.api.modules.people.domain.repository.AgentDataRepository
import org.springframework.http.HttpStatus.NOT_FOUND
import org.springframework.http.HttpStatus.OK
import org.springframework.http.ResponseEntity

@Usecase
class AgentProfileUsecase(
    private val repository: AgentDataRepository,
) : IAgentProfileUsecase {
    override fun getProfile(agentId: String): ResponseEntity<ApiResponse<ProfileDto>> {
        return repository.findById(agentId).map {
            successResponse(OK, ProfileDto.toTrimRequest(it.profile))
        }.orElse(errorResponse(NOT_FOUND, notFoundMessageAsList("agent")))
    }

    override fun updateProfile(agentId: String, profileDto: ProfileDto): ResponseEntity<ApiResponse<ProfileDto>> {
        return repository.findById(agentId).map {
            it.profile = ProfileDto.toEntity(profileDto.apply { id = it.profile.id })
            successResponse(OK, ProfileDto.toTrimRequest(repository.save(it).profile))
        }.orElse(errorResponse(NOT_FOUND, notFoundMessageAsList("agent")))
    }
}