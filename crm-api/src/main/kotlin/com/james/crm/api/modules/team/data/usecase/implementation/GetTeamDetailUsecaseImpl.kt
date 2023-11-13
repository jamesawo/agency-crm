/*
 * @Author: james.aworo
 * @Date: 11/13/23
 *
 * @Project: agent-crm
 */

package com.james.crm.api.modules.team.data.usecase.implementation

import com.james.crm.api.core.annotation.Usecase
import com.james.crm.api.core.common.ApiResponse
import com.james.crm.api.core.common.CatchableError
import com.james.crm.api.core.util.Util.Companion.errorResponse
import com.james.crm.api.core.util.Util.Companion.notFoundMessageAsList
import com.james.crm.api.core.util.Util.Companion.successResponse
import com.james.crm.api.modules.team.data.dto.TeamDetailDto
import com.james.crm.api.modules.team.data.repository.TeamDataRepository
import com.james.crm.api.modules.team.data.usecase.contract.IGetTeamDetailUsecase
import org.springframework.http.HttpStatus.*
import org.springframework.http.ResponseEntity

@Usecase
class GetTeamDetailUsecaseImpl(
    private val teamRepository: TeamDataRepository
) : IGetTeamDetailUsecase {

    override fun execute(input: String): ResponseEntity<ApiResponse<TeamDetailDto>> {
        return try {
            teamRepository.findById(input).map { team ->
                successResponse(OK, TeamDetailDto.toRequest(team))
            }.orElse(errorResponse(NOT_FOUND, notFoundMessageAsList("team")))
        } catch (ex: Exception) {
            errorResponse(
                INTERNAL_SERVER_ERROR,
                CatchableError(INTERNAL_SERVER_ERROR, listOf(ex.localizedMessage), ex)
            )
        }
    }
}