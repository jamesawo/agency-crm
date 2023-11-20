/*
 * @Author: james.aworo
 * @Date: 11/11/23
 *
 * @Project: agent-crm
 */

package com.james.crm.api.modules.team.endpoint

import com.james.crm.api.core.common.ApiResponse
import com.james.crm.api.core.common.Paginate
import com.james.crm.api.core.constant.Route
import com.james.crm.api.modules.people.data.dto.agent.AgentDto
import com.james.crm.api.modules.people.data.dto.other.LocationDto
import com.james.crm.api.modules.team.data.dto.TeamDetailDto
import com.james.crm.api.modules.team.data.dto.TeamDto
import com.james.crm.api.modules.team.data.dto.TeamLocationDto
import com.james.crm.api.modules.team.data.dto.TeamPerformanceDto
import com.james.crm.api.modules.team.data.usecase.contract.*
import com.james.crm.api.modules.team.data.usecase.implementation.GetTeamDetailUsecaseImpl
import jakarta.validation.Valid
import org.springframework.data.domain.PageRequest
import org.springframework.data.domain.Sort
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("${Route.API_VERSION}/teams/")
class TeamEndpoint(
    private var createTeamUsecase: ICreateTeamUsecase,
    private var getLocationUsecase: IGetAllTeamLocationUsecase,
    private var setTeamBudgetUsecase: ISetTeamBudgetUseCase,
    private var setTeamTaskUseCase: ISetTeamTaskUseCase,
    private var getTeamDetailUsecaseImpl: GetTeamDetailUsecaseImpl,
    private var getTeamsUsecase: IGetTeamUsecase,
    private var setTeamLocation: ISetTeamLocationUsecase,
    private var setTeamManager: ISetTeamManagerUsecase,
    private var getTeamAgentUsecase: IGetTeamAgentUsecase,
    private var getTeamPerformanceUsecase: IGetTeamPerformanceUsecase
) {

    @GetMapping
    fun getAllTeams(
        @RequestParam(defaultValue = "1") page: Int,
        @RequestParam(defaultValue = "10") size: Int,
        @RequestParam(defaultValue = "ASC", required = false) sort: Sort.Direction
    ): ResponseEntity<ApiResponse<Paginate<TeamDetailDto>>> {
        return getTeamsUsecase.execute(
            PageRequest.of(
                page - 1, size,
                Sort.by(sort, "title")
            )
        )
    }


    /*TODO::
        consider merging this into GET ALL api route above
        ie. can use query params to filter/structure the response
     */
    @GetMapping("/all-locations")
    fun getTeamLocation(): ResponseEntity<ApiResponse<List<TeamLocationDto>>> {
        return getLocationUsecase.execute(Unit)
    }

    @PostMapping
    fun createTeam(
        @Valid @RequestBody input: TeamDetailDto
    ): ResponseEntity<ApiResponse<TeamDto>> {
        return createTeamUsecase.execute(input)
    }

    @GetMapping("{teamId}")
    fun getTeamDetail(
        @PathVariable(required = true) teamId: String
    ): ResponseEntity<ApiResponse<TeamDetailDto>> {
        return getTeamDetailUsecaseImpl.execute(teamId)
    }

    @PutMapping("{teamId}/set-location")
    fun setTeamLocation(
        @PathVariable(required = true) teamId: String,
        @RequestBody location: LocationDto
    ): ResponseEntity<ApiResponse<TeamLocationDto>> {
        return setTeamLocation.execute(Pair(teamId, location))
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

    @PutMapping("{teamId}/set-manager/{managerId}")
    fun setTeamManager(
        @PathVariable(required = true) teamId: String,
        @PathVariable(required = true) managerId: String,
    ): ResponseEntity<ApiResponse<TeamDetailDto>> {
        return setTeamManager.execute(Pair(teamId, managerId))
    }

    @GetMapping("{teamId}/agents")
    fun getTeamAgents(
        @PathVariable(required = true) teamId: String
    ): ResponseEntity<ApiResponse<List<AgentDto>>> {
        return getTeamAgentUsecase.execute(teamId)
    }

    @GetMapping("{teamId}/performance")
    fun getTeamPerformance(
        @PathVariable(required = true) teamId: String
    ): ResponseEntity<ApiResponse<TeamPerformanceDto>> {
        return getTeamPerformanceUsecase.execute(teamId)
    }

}