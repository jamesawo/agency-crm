/*
 * @Author: james.aworo
 * @Date: 11/8/23
 *
 * @Project: agent-crm
 */

package com.james.crm.api.modules.people.data.usecase.contract.agent

import com.james.crm.api.core.common.ApiResponse
import com.james.crm.api.modules.team.data.dto.TeamDto
import org.springframework.http.ResponseEntity

interface IAgentTeamUsecase {
    fun getTeam(agentId: String): ResponseEntity<ApiResponse<TeamDto?>>
    fun updateTeam(agentId: String, teamId: String): ResponseEntity<ApiResponse<Boolean>>
}