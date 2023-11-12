/*
 * @Author: james.aworo
 * @Date: 11/11/23
 *
 * @Project: agent-crm
 */

package com.james.crm.api.modules.team.data.usecase.implementation

import com.james.crm.api.core.annotation.Usecase
import com.james.crm.api.core.common.ApiResponse
import com.james.crm.api.modules.team.data.dto.TeamDto
import com.james.crm.api.modules.team.data.repository.TeamDataRepository
import com.james.crm.api.modules.team.data.usecase.contract.ISetTeamBudgetUseCase
import org.springframework.http.ResponseEntity

@Usecase
class SetTeamBudgetUseCaseImpl(
    private val teamRepository: TeamDataRepository
) : ISetTeamBudgetUseCase {

    /* override fun setTeamBudget(teamId: String, budget: Double): ResponseEntity<TeamDto> {
        *//*val team = teamRepository.findById(teamId)
        if (!team.isPresent) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build()
        }
        team.get().budget = budget
        val updatedTeam = teamRepository.save(team.get())
        return ResponseEntity.ok(TeamDto.toRequest(updatedTeam))*//*
        TODO()
    }*/
    override fun execute(input: Pair<String, Double>): ResponseEntity<ApiResponse<TeamDto>> {
        TODO("Not yet implemented")
    }
}