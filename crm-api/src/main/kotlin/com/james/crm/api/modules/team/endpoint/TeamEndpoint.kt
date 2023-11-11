/*
 * @Author: james.aworo
 * @Date: 11/11/23
 *
 * @Project: agent-crm
 */

package com.james.crm.api.modules.team.endpoint

import com.james.crm.api.core.constant.Route
import com.james.crm.api.modules.team.data.dto.TeamDetailDto
import com.james.crm.api.modules.team.data.dto.TeamDto
import com.james.crm.api.modules.team.data.usecase.contract.*
import jakarta.validation.Valid
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("${Route.API_VERSION}/teams/")
class TeamEndpoint(
    private var assignAgentUsecase: IAssignAgentToTeamUseCase,
    private var createTeamUsecase: ICreateTeamUsecase,
    private var getTeamsLocation: IGetTeamLocationUsecase,
    private var setTeamBudget: ISetTeamBudgetUseCase,
    private var setTeamTaskUseCase: ISetTeamTaskUseCase
) {

    @PostMapping
    fun createTeam(@Valid @RequestBody input: TeamDetailDto): ResponseEntity<TeamDto> {
        return createTeamUsecase.execute(input)
    }

   
}