/*
 * @Author: james.aworo
 * @Date: 11/8/23
 *
 * @Project: agent-crm
 */

package com.james.crm.api.modules.people.endpoint.agent

import com.james.crm.api.core.constant.Route
import com.james.crm.api.modules.people.data.dto.TeamDto
import com.james.crm.api.modules.people.data.usecase.contract.agent.IAgentTeamUsecase
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("${Route.BASE}/agents/{agentId}/team")
class AgentTeamEndpoint(
    private val teamUsecase: IAgentTeamUsecase
) {
    
    @GetMapping("/{id}/team")
    fun getTeam(@PathVariable id: String, @PathVariable agentId: String): ResponseEntity<TeamDto> {
        return teamUsecase.getTeam(id)
    }

    @PutMapping("/{id}/team")
    fun updateTeam(
        @PathVariable id: String,
        @RequestBody teamDto: TeamDto,
        @PathVariable agentId: String
    ): ResponseEntity<TeamDto> {
        return teamUsecase.updateTeam(id, teamDto)
    }

}