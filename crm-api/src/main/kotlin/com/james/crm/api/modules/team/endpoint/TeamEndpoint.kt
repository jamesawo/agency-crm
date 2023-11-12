/*
 * @Author: james.aworo
 * @Date: 11/11/23
 *
 * @Project: agent-crm
 */

package com.james.crm.api.modules.team.endpoint

import com.james.crm.api.core.common.ApiResponse
import com.james.crm.api.core.constant.Route
import com.james.crm.api.modules.team.data.dto.TeamDetailDto
import com.james.crm.api.modules.team.data.dto.TeamDto
import com.james.crm.api.modules.team.data.usecase.contract.*
import jakarta.validation.Valid
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

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
    fun createTeam(@Valid @RequestBody input: TeamDetailDto): ResponseEntity<ApiResponse<TeamDto>> {
        return createTeamUsecase.execute(input)
    }

    @PostMapping("{teamId}/assign-agent/{agentId}/")
    fun assignAgentToTeam(
        @PathVariable agentId: String,
        @PathVariable teamId: String
    ): ResponseEntity<ApiResponse<Boolean>> {
        return assignAgentUsecase.execute(Pair(agentId, teamId))
    }


}