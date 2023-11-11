/*
 * @Author: james.aworo
 * @Date: 11/11/23
 *
 * @Project: agent-crm
 */

package com.james.crm.api.modules.team.data.usecase.implementation

import com.james.crm.api.core.annotation.Usecase
import com.james.crm.api.modules.people.data.dto.TeamDto
import com.james.crm.api.modules.people.domain.repository.TaskDataRepository
import com.james.crm.api.modules.team.data.repository.TeamDataRepository
import com.james.crm.api.modules.team.data.usecase.contract.SetTeamTaskUseCase
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity

@Usecase
class SetTeamTaskUseCaseImpl(
    private val teamRepository: TeamDataRepository,
    private val taskRepository: TaskDataRepository
) : SetTeamTaskUseCase {

    override fun setTeamTask(teamId: String, taskId: String): ResponseEntity<TeamDto> {
        val team = teamRepository.findById(teamId)
        val task = taskRepository.findById(taskId)
        if (!team.isPresent || !task.isPresent) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build()
        }
        team.get().tasks?.add(task.get())
        val updatedTeam = teamRepository.save(team.get())
        return ResponseEntity.ok(TeamDto.toRequest(updatedTeam))
    }
}