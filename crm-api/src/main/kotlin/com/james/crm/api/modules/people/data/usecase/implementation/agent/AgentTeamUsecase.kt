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
import com.james.crm.api.modules.people.data.usecase.contract.agent.IAgentTeamUsecase
import com.james.crm.api.modules.people.domain.repository.AgentDataRepository
import com.james.crm.api.modules.team.data.dto.TeamDto
import com.james.crm.api.modules.team.data.repository.TeamDataRepository
import org.springframework.http.HttpStatus.NOT_FOUND
import org.springframework.http.HttpStatus.OK
import org.springframework.http.ResponseEntity

@Usecase
class AgentTeamUsecase(
    private val repository: AgentDataRepository,
    private val teamRepository: TeamDataRepository,
) : IAgentTeamUsecase {
    override fun getTeam(agentId: String): ResponseEntity<ApiResponse<TeamDto?>> {
        return repository.findById(agentId).map {
            val teamDto = it.team?.let { it1 -> TeamDto.toTrimRequest(it1) }
            successResponse(OK, teamDto)
        }.orElse(errorResponse(NOT_FOUND, notFoundMessageAsList("agent")))
    }

    override fun updateTeam(agentId: String, teamId: String): ResponseEntity<ApiResponse<Boolean>> {
        return repository.findById(agentId).flatMap { agent ->
            teamRepository.findById(agentId).map { team ->
                agent.team = team
                repository.save(agent)
                successResponse(OK, true)
            }
        }.orElse(errorResponse(NOT_FOUND, notFoundMessageAsList("agent")))
    }
}