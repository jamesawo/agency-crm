/*
 * @Author: james.aworo
 * @Date: 11/11/23
 *
 * @Project: agent-crm
 */

package com.james.crm.api.modules.team.data.usecase.implementation

import com.james.crm.api.core.annotation.Usecase
import com.james.crm.api.modules.people.data.dto.TeamDto
import com.james.crm.api.modules.people.domain.repository.AgentDataRepository
import com.james.crm.api.modules.team.data.repository.TeamDataRepository
import com.james.crm.api.modules.team.data.usecase.contract.AssignAgentToTeamUseCase
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity


@Usecase
class AssignAgentToTeamUseCaseImpl(
    private val teamRepository: TeamDataRepository,
    private val agentRepository: AgentDataRepository
) : AssignAgentToTeamUseCase {

    override fun assignAgentToTeam(agentId: String, teamId: String): ResponseEntity<TeamDto> {
        val agent = agentRepository.findById(agentId)
        val team = teamRepository.findById(teamId)

        if (!agent.isPresent || !team.isPresent) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build()
        }
        team.get().agents?.add(agent.get())
        val updatedTeam = teamRepository.save(team.get())
        return ResponseEntity.ok(TeamDto.toRequest(updatedTeam))
    }
}
