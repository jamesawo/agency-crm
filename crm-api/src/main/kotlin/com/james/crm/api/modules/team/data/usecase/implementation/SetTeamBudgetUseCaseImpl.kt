/*
 * @Author: james.aworo
 * @Date: 11/11/23
 *
 * @Project: agent-crm
 */

package com.james.crm.api.modules.team.data.usecase.implementation

import com.james.crm.api.core.annotation.Usecase
import com.james.crm.api.core.common.ApiResponse
import com.james.crm.api.core.util.Util.Companion.errorResponse
import com.james.crm.api.core.util.Util.Companion.notFoundMessageAsList
import com.james.crm.api.core.util.Util.Companion.successResponse
import com.james.crm.api.modules.team.data.dto.TeamDto
import com.james.crm.api.modules.team.data.repository.TeamDataRepository
import com.james.crm.api.modules.team.data.usecase.contract.ISetTeamBudgetUseCase
import org.springframework.http.HttpStatus
import org.springframework.http.HttpStatus.NOT_FOUND
import org.springframework.http.ResponseEntity

@Usecase
class SetTeamBudgetUseCaseImpl(
    private val teamRepository: TeamDataRepository
) : ISetTeamBudgetUseCase {

    override fun execute(input: Pair<String, Double>): ResponseEntity<ApiResponse<TeamDto>> {
        return teamRepository.findById(input.first).map { team ->
            team.budget = input.second
            successResponse(HttpStatus.OK, TeamDto.toTrimRequest(teamRepository.save(team)))
        }.orElse(errorResponse(NOT_FOUND, notFoundMessageAsList("team")))
    }
}