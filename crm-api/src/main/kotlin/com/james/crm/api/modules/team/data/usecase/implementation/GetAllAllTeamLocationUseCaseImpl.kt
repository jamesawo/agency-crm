/*
 * @Author: james.aworo
 * @Date: 11/11/23
 *
 * @Project: agent-crm
 */

package com.james.crm.api.modules.team.data.usecase.implementation

import com.james.crm.api.core.annotation.Usecase
import com.james.crm.api.core.common.ApiResponse
import com.james.crm.api.core.common.CatchableError
import com.james.crm.api.core.common.Empty
import com.james.crm.api.core.util.Util.Companion.errorResponse
import com.james.crm.api.core.util.Util.Companion.successResponse
import com.james.crm.api.modules.team.data.dto.TeamLocationDto
import com.james.crm.api.modules.team.data.repository.TeamDataRepository
import com.james.crm.api.modules.team.data.usecase.contract.IGetAllTeamLocationUsecase
import org.springframework.http.HttpStatus
import org.springframework.http.HttpStatus.INTERNAL_SERVER_ERROR
import org.springframework.http.ResponseEntity

@Usecase
class GetAllAllTeamLocationUseCaseImpl(
    private val teamRepository: TeamDataRepository
) : IGetAllTeamLocationUsecase {
    override fun execute(input: Empty): ResponseEntity<ApiResponse<List<TeamLocationDto>>> {
        return try {
            val dtoList = teamRepository.findAll()
                .filter { it.location != null }
                .map { TeamLocationDto.toTrimRequest(it) }
            successResponse(HttpStatus.OK, dtoList)
        } catch (ex: Exception) {
            errorResponse(INTERNAL_SERVER_ERROR, CatchableError(INTERNAL_SERVER_ERROR, ex))
        }
    }
}
