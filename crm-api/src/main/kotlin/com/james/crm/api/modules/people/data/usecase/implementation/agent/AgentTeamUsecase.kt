/*
 * @Author: james.aworo
 * @Date: 11/8/23
 *
 * @Project: agent-crm
 */

package com.james.crm.api.modules.people.data.usecase.implementation.agent

import com.james.crm.api.core.annotation.Usecase
import com.james.crm.api.modules.people.data.dto.TeamDto
import com.james.crm.api.modules.people.data.usecase.contract.agent.IAgentTeamUsecase
import org.springframework.http.ResponseEntity

@Usecase
class AgentTeamUsecase : IAgentTeamUsecase {
    override fun getTeam(agentId: String): ResponseEntity<TeamDto> {
        TODO()
    }

    override fun updateTeam(agentId: String, teamDto: TeamDto): ResponseEntity<TeamDto> {
        TODO()
    }
}