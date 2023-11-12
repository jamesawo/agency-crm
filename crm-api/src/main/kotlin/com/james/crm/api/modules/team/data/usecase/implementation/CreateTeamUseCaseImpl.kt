/*
 * @Author: james.aworo
 * @Date: 11/11/23
 *
 * @Project: agent-crm
 */

package com.james.crm.api.modules.team.data.usecase.implementation

import com.james.crm.api.core.annotation.Usecase
import com.james.crm.api.core.common.ApiResponse
import com.james.crm.api.core.common.ErrorResponse
import com.james.crm.api.core.common.SuccessResponse
import com.james.crm.api.modules.people.domain.repository.ManagerDataRepository
import com.james.crm.api.modules.team.data.dto.TeamDetailDto
import com.james.crm.api.modules.team.data.dto.TeamDto
import com.james.crm.api.modules.team.data.repository.TeamDataRepository
import com.james.crm.api.modules.team.data.usecase.contract.ICreateTeamUsecase
import com.james.crm.api.modules.team.domain.Team
import org.springframework.http.HttpStatus
import org.springframework.http.HttpStatus.INTERNAL_SERVER_ERROR
import org.springframework.http.ResponseEntity

@Usecase
class CreateTeamUseCaseImpl(
    private val teamRepository: TeamDataRepository,
    private val managerRepository: ManagerDataRepository
) : ICreateTeamUsecase {

    override fun execute(input: TeamDetailDto): ResponseEntity<ApiResponse<TeamDto>> {
        return try {
            val manager = input.managerId?.let { managerRepository.findById(it) }
            val savedTeam =
                teamRepository.save(Team(title = input.title, manager = manager?.orElse(null), budget = input.budget))
            ResponseEntity.status(HttpStatus.CREATED).body(
                SuccessResponse(
                    HttpStatus.CREATED, TeamDto.toTrimRequest(savedTeam)
                )
            )
        } catch (ex: Exception) {
            ResponseEntity.status(INTERNAL_SERVER_ERROR)
                .body(ErrorResponse(INTERNAL_SERVER_ERROR, listOf(ex.localizedMessage)))
        }

    }
}
