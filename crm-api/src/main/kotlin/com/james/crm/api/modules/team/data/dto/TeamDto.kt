package com.james.crm.api.modules.team.data.dto

import com.fasterxml.jackson.annotation.JsonInclude
import com.james.crm.api.core.model.Mapper
import com.james.crm.api.modules.people.data.dto.AgentDto
import com.james.crm.api.modules.people.data.dto.LocationDto
import com.james.crm.api.modules.people.data.dto.ManagerDto
import com.james.crm.api.modules.people.data.dto.TaskDto
import com.james.crm.api.modules.team.domain.Team


@JsonInclude(JsonInclude.Include.NON_NULL)
data class TeamDto(var id: String?) {
    var title: String = ""
    var manager: ManagerDto? = null
    var agents: List<AgentDto>? = null
    var location: LocationDto? = null
    var budget: Double = 0.00
    var tasks: List<TaskDto>? = null

    constructor() : this(id = null)

    constructor(
        id: String?,
        title: String,
        manager: ManagerDto?,
        agents: List<AgentDto>?,
        location: LocationDto?,
        budget: Double,
        tasks: List<TaskDto>?
    ) : this(id) {
        this.title = title
        this.manager = manager
        this.agents = agents
        this.location = location
        this.budget = budget
        this.tasks = tasks
    }

    constructor(id: String?, title: String, budget: Double) : this(id) {
        this.id = id
        this.title = title
        this.budget = budget
    }

    companion object : Mapper<TeamDto, Team> {

        override fun toRequest(entity: Team): TeamDto {
            return TeamDto(
                id = entity.id,
                title = entity.title,
                manager = entity.manager?.let { ManagerDto.toRequest(it) },
                agents = entity.agents?.map { AgentDto.toRequest(it) },
                location = entity.location?.let { LocationDto.toRequest(it) },
                budget = entity.budget,
                tasks = entity.tasks?.map { TaskDto.toRequest(it) }
            )
        }

        override fun toEntity(request: TeamDto): Team {
            val team = Team()
            team.title = request.title
            team.manager = request.manager?.let { ManagerDto.toEntity(it) }
            team.agents = request.agents?.map { AgentDto.toEntity(it) }?.toMutableList()
            team.location = request.location?.let { LocationDto.toEntity(it) }
            team.budget = request.budget
            team.tasks = request.tasks?.map { TaskDto.toEntity(it) }?.toMutableList()
            return team
        }

        override fun toTrimmedRequest(entity: Team): TeamDto {
            return TeamDto(
                id = entity.id,
                title = entity.title,
                budget = entity.budget,
            )
        }
    }

}
