/*
 * @Author: james.aworo
 * @Date: 11/8/23
 *
 * @Project: agent-crm
 */

package com.james.crm.api.modules.people.data.usecase.implementation.agent

import com.james.crm.api.core.annotation.Usecase
import com.james.crm.api.core.common.ApiResponse
import com.james.crm.api.modules.people.data.usecase.contract.agent.IAgentTeamUsecase
import com.james.crm.api.modules.team.data.dto.TeamDto
import org.springframework.http.ResponseEntity

@Usecase
class AgentTeamUsecase : IAgentTeamUsecase {
    override fun getTeam(agentId: String): ResponseEntity<ApiResponse<TeamDto>> {
        TODO()
    }

    override fun updateTeam(agentId: String, teamDto: TeamDto): ResponseEntity<ApiResponse<TeamDto>> {
        TODO()
    }
}