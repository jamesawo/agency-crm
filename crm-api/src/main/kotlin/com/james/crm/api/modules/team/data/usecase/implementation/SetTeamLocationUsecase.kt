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
import com.james.crm.api.core.util.Util
import com.james.crm.api.core.util.Util.Companion.errorResponse
import com.james.crm.api.core.util.Util.Companion.successResponse
import com.james.crm.api.modules.people.data.dto.other.LocationDto
import com.james.crm.api.modules.team.data.dto.TeamLocationDto
import com.james.crm.api.modules.team.data.repository.TeamDataRepository
import com.james.crm.api.modules.team.data.usecase.contract.ISetTeamLocationUsecase
import org.springframework.http.HttpStatus.*
import org.springframework.http.ResponseEntity

@Usecase
class SetTeamLocationUsecase(
    private val teamRepository: TeamDataRepository
) : ISetTeamLocationUsecase {

    override fun execute(input: Pair<String, LocationDto>): ResponseEntity<ApiResponse<TeamLocationDto>> {
        return try {
            teamRepository.findById(input.first).map { team ->
                team.location = LocationDto.toEntity(input.second)
                val save = teamRepository.save(team)
                successResponse(OK, TeamLocationDto.toTrimRequest(save))
            }.orElse(errorResponse(NOT_FOUND, Util.notFoundMessageAsList("team")))

        } catch (ex: Exception) {
            errorResponse(INTERNAL_SERVER_ERROR, CatchableError(INTERNAL_SERVER_ERROR, listOf(ex.localizedMessage), ex))
        }
    }
}