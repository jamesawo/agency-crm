/*
 * @Author: james.aworo
 * @Date: 11/11/23
 *
 * @Project: agent-crm
 */

package com.james.crm.api.modules.team.data.usecase.contract

import com.james.crm.api.modules.team.data.dto.TeamDto
import org.springframework.http.ResponseEntity


// Usecase for viewing teams on the map

// Usecase for setting the budget for a team
interface SetTeamBudgetUseCase

// Usecase for setting tasks for a team
interface SetTeamTaskUseCase {
    fun setTeamTask(teamId: String, taskId: String): ResponseEntity<TeamDto>
}