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
import com.james.crm.api.modules.people.domain.repository.ManagerDataRepository
import com.james.crm.api.modules.team.data.dto.TeamDetailDto
import com.james.crm.api.modules.team.data.dto.TeamDto
import com.james.crm.api.modules.team.data.dto.TeamDto.Companion.toTrimRequest
import com.james.crm.api.modules.team.data.repository.TeamDataRepository
import com.james.crm.api.modules.team.data.usecase.contract.ICreateTeamUsecase
import com.james.crm.api.modules.team.domain.Team
import org.springframework.http.HttpStatus.CREATED
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
            val savedTeam = teamRepository.save(Team(input.title, manager?.orElse(null), input.budget))
            successResponse(CREATED, toTrimRequest(savedTeam))
        } catch (ex: Exception) {
            errorResponse(INTERNAL_SERVER_ERROR, notFoundMessageAsList(ex.localizedMessage))
        }
    }
}
