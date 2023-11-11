/*
 * @Author: james.aworo
 * @Date: 11/11/23
 *
 * @Project: agent-crm
 */

package com.james.crm.api.modules.team.data.usecase.implementation

import com.james.crm.api.core.annotation.Usecase
import com.james.crm.api.modules.people.data.dto.TeamDto
import com.james.crm.api.modules.team.data.repository.TeamDataRepository
import com.james.crm.api.modules.team.data.usecase.contract.SetTeamBudgetUseCase
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity

@Usecase
class SetTeamBudgetUseCaseImpl(
    private val teamRepository: TeamDataRepository
) : SetTeamBudgetUseCase {

    override fun setTeamBudget(teamId: String, budget: Double): ResponseEntity<TeamDto> {
        val team = teamRepository.findById(teamId)
        if (!team.isPresent) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build()
        }
        team.get().budget = budget
        val updatedTeam = teamRepository.save(team.get())
        return ResponseEntity.ok(TeamDto.toRequest(updatedTeam))
    }
}