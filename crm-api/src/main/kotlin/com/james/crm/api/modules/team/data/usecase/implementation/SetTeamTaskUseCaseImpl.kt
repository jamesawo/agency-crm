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
import com.james.crm.api.modules.people.domain.repository.TaskDataRepository
import com.james.crm.api.modules.team.data.dto.TeamDto
import com.james.crm.api.modules.team.data.repository.TeamDataRepository
import com.james.crm.api.modules.team.data.usecase.contract.ISetTeamTaskUseCase
import org.springframework.http.HttpStatus.NOT_FOUND
import org.springframework.http.HttpStatus.OK
import org.springframework.http.ResponseEntity

@Usecase
class SetTeamTaskUseCaseImpl(
    private val teamRepository: TeamDataRepository,
    private val taskRepository: TaskDataRepository
) : ISetTeamTaskUseCase {

    override fun execute(input: Pair<String, String>): ResponseEntity<ApiResponse<TeamDto>> {
        return teamRepository.findById(input.first).flatMap { team ->
            taskRepository.findById(input.second).map { task ->
                team.tasks?.add(task)
                val savedTeam = teamRepository.save(team)
                successResponse(OK, TeamDto.toTrimRequest(savedTeam))
            }
        }.orElse(errorResponse(NOT_FOUND, notFoundMessageAsList("team")))
    }
}