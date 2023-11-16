/*
 * @Author: james.aworo
 * @Date: 11/8/23
 *
 * @Project: agent-crm
 */

package com.james.crm.api.modules.people.endpoint.agent

import com.james.crm.api.core.common.ApiResponse
import com.james.crm.api.core.constant.Route
import com.james.crm.api.modules.people.data.usecase.contract.agent.IAgentTeamUsecase
import com.james.crm.api.modules.team.data.dto.TeamDto
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("${Route.API_VERSION}/agents/{agentId}/team")
class AgentTeamEndpoint(
    private val teamUsecase: IAgentTeamUsecase
) {

    @GetMapping
    fun getTeam(
        @PathVariable agentId: String
    ): ResponseEntity<ApiResponse<TeamDto?>> {
        return teamUsecase.getTeam(agentId)
    }

    @PatchMapping("/{teamId}")
    fun updateTeam(
        @PathVariable agentId: String,
        @PathVariable teamId: String
    ): ResponseEntity<ApiResponse<Boolean>> {
        return teamUsecase.updateTeam(agentId, teamId)
    }

}