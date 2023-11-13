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
import com.james.crm.api.core.common.Paginate
import com.james.crm.api.core.util.Util.Companion.errorResponse
import com.james.crm.api.core.util.Util.Companion.successResponse
import com.james.crm.api.modules.team.data.dto.TeamDetailDto
import com.james.crm.api.modules.team.data.repository.TeamDataRepository
import com.james.crm.api.modules.team.data.usecase.contract.IGetTeamsUsecase
import org.springframework.data.domain.PageImpl
import org.springframework.data.domain.Pageable
import org.springframework.http.HttpStatus.INTERNAL_SERVER_ERROR
import org.springframework.http.HttpStatus.OK
import org.springframework.http.ResponseEntity

@Usecase
class GetTeamsUsecase(
    private val teamRepo: TeamDataRepository
) : IGetTeamsUsecase {

    override fun execute(input: Pageable): ResponseEntity<ApiResponse<Paginate<TeamDetailDto>>> {
        return try {
            val teamPage = teamRepo.findAll(input)
            val teamDetailList: List<TeamDetailDto> = teamPage.content.map { TeamDetailDto.toTrimRequest(it) }
            successResponse(OK, Paginate.fromPage(PageImpl(teamDetailList, input, teamPage.totalElements)))
        } catch (ex: Exception) {
            errorResponse(INTERNAL_SERVER_ERROR, CatchableError(INTERNAL_SERVER_ERROR, listOf(ex.localizedMessage), ex))
        }
    }
}
