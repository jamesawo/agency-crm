/*
 * @Author: james.aworo
 * @Date: 11/8/23
 *
 * @Project: agent-crm
 */

package com.james.crm.api.modules.people.data.usecase.contract.agent

import com.james.crm.api.modules.people.data.dto.TeamDto
import org.springframework.http.ResponseEntity

interface IAgentTeamUsecase {
    fun getTeam(agentId: String): ResponseEntity<TeamDto>
    fun updateTeam(agentId: String, teamDto: TeamDto): ResponseEntity<TeamDto>
}