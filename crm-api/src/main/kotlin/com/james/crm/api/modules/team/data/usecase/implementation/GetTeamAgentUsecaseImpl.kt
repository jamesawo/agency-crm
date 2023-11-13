/*
 * @Author: james.aworo
 * @Date: 11/13/23
 *
 * @Project: agent-crm
 */

package com.james.crm.api.modules.team.data.usecase.implementation

import com.james.crm.api.core.annotation.Usecase
import com.james.crm.api.core.common.ApiResponse
import com.james.crm.api.core.util.Util.Companion.errorResponse
import com.james.crm.api.core.util.Util.Companion.notFoundMessageAsList
import com.james.crm.api.core.util.Util.Companion.successResponse
import com.james.crm.api.modules.people.data.dto.AgentDto
import com.james.crm.api.modules.team.data.repository.TeamDataRepository
import com.james.crm.api.modules.team.data.usecase.contract.IGetTeamAgentUsecase
import org.springframework.http.HttpStatus.NOT_FOUND
import org.springframework.http.HttpStatus.OK
import org.springframework.http.ResponseEntity

@Usecase
class GetTeamAgentUsecaseImpl(
    private val teamRepository: TeamDataRepository
) : IGetTeamAgentUsecase {

    override fun execute(input: String): ResponseEntity<ApiResponse<List<AgentDto>>> {
        return teamRepository.findById(input).map { team ->
            val dtoList = team.agents?.map { agent -> AgentDto.toTrimRequest(agent) } ?: listOf()
            successResponse(OK, dtoList)
        }.orElse(errorResponse(NOT_FOUND, notFoundMessageAsList("team")))
    }
}