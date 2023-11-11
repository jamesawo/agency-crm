/*
 * @Author: james.aworo
 * @Date: 11/11/23
 *
 * @Project: agent-crm
 */

package com.james.crm.api.modules.team.data.usecase.implementation

import com.james.crm.api.core.annotation.Usecase
import com.james.crm.api.modules.people.data.dto.TeamDto
import com.james.crm.api.modules.people.domain.repository.ManagerDataRepository
import com.james.crm.api.modules.team.data.dto.TeamDetail
import com.james.crm.api.modules.team.data.repository.TeamDataRepository
import com.james.crm.api.modules.team.data.usecase.contract.CreateTeamUseCase
import com.james.crm.api.modules.team.domain.Team
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity

@Usecase
class CreateTeamUseCaseImpl(
    private val teamRepository: TeamDataRepository,
    private val managerRepository: ManagerDataRepository
) : CreateTeamUseCase {

    override fun createTeam(teamDetails: TeamDetail): ResponseEntity<TeamDto> {
        val manager = managerRepository.findById(teamDetails.managerId)
        if (!manager.isPresent) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build()
        }
        val newTeam = Team(
            title = teamDetails.name,
            manager = manager.get(),
            budget = teamDetails.budget,
        )
        val savedTeam = teamRepository.save(newTeam)
        return ResponseEntity.status(HttpStatus.CREATED).body(TeamDto.toRequest(savedTeam))
    }
}
