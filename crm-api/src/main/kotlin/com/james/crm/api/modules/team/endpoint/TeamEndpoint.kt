/*
 * @Author: james.aworo
 * @Date: 11/11/23
 *
 * @Project: agent-crm
 */

package com.james.crm.api.modules.team.endpoint

import com.james.crm.api.core.common.ApiResponse
import com.james.crm.api.core.common.Empty
import com.james.crm.api.core.constant.Route
import com.james.crm.api.modules.people.data.dto.LocationDto
import com.james.crm.api.modules.team.data.dto.TeamDetailDto
import com.james.crm.api.modules.team.data.dto.TeamDto
import com.james.crm.api.modules.team.data.usecase.contract.*
import com.james.crm.api.modules.team.data.usecase.implementation.GetTeamDetailUsecaseImpl
import jakarta.validation.Valid
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("${Route.API_VERSION}/teams/")
class TeamEndpoint(
    private var createTeamUsecase: ICreateTeamUsecase,
    private var getLocationUsecase: IGetAllTeamLocationUsecase,
    private var setTeamBudgetUsecase: ISetTeamBudgetUseCase,
    private var setTeamTaskUseCase: ISetTeamTaskUseCase,
    private var getTeamDetailUsecaseImpl: GetTeamDetailUsecaseImpl
) {

    @PostMapping
    fun createTeam(
        @Valid @RequestBody input: TeamDetailDto
    ): ResponseEntity<ApiResponse<TeamDto>> {
        return createTeamUsecase.execute(input)
    }

    @GetMapping("/all-locations")
    fun getTeamLocation(): ResponseEntity<ApiResponse<List<LocationDto>>> {
        return getLocationUsecase.execute(Empty())
    }

    @PutMapping("{teamId}/set-budget")
    fun setTeamBudget(
        @PathVariable(required = true) teamId: String,
        @RequestParam(required = true) budget: Double
    ): ResponseEntity<ApiResponse<TeamDto>> {
        return setTeamBudgetUsecase.execute(Pair(teamId, budget))
    }

    @PutMapping("{teamId}/set-task/{taskId}")
    fun setTeamTask(
        @PathVariable(required = true) teamId: String,
        @PathVariable(required = true) taskId: String,
    ): ResponseEntity<ApiResponse<TeamDto>> {
        return setTeamTaskUseCase.execute(Pair(teamId, taskId))
    }

    @GetMapping("{teamId}")
    fun getTeamDetail(
        @PathVariable(required = true) teamId: String
    ): ResponseEntity<ApiResponse<TeamDetailDto>> {
        return getTeamDetailUsecaseImpl.execute(teamId)
    }

}