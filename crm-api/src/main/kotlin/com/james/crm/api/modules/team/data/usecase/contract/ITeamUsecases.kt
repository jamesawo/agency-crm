/*
 * @Author: james.aworo
 * @Date: 11/11/23
 *
 * @Project: agent-crm
 */

package com.james.crm.api.modules.team.data.usecase.contract

import com.james.crm.api.modules.people.data.dto.LocationDto
import com.james.crm.api.modules.people.data.dto.TeamDto
import com.james.crm.api.modules.team.data.dto.TeamDetail
import org.springframework.http.ResponseEntity


interface CreateTeamUseCase {
    fun createTeam(teamDetails: TeamDetail): ResponseEntity<TeamDto>
}

// Interface for assigning an agent to a team
interface AssignAgentToTeamUseCase {
    fun assignAgentToTeam(agentId: String, teamId: String): ResponseEntity<TeamDto>
}

// Interface for viewing teams on the map
interface GetTeamLocationUsecase {
    fun getTeamLocations(): ResponseEntity<List<LocationDto>>
}

// Interface for setting the budget for a team
interface SetTeamBudgetUseCase {
    fun setTeamBudget(teamId: String, budget: Double): ResponseEntity<TeamDto>
}

// Interface for setting tasks for a team
interface SetTeamTaskUseCase {
    fun setTeamTask(teamId: String, taskId: String): ResponseEntity<TeamDto>
}