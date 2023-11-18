/*
 * @Author: james.aworo
 * @Date: 11/11/23
 *
 * @Project: agent-crm
 */

package com.james.crm.api.modules.team.data.dto

import com.james.crm.api.core.common.Mapper
import com.james.crm.api.modules.people.data.dto.manager.ManagerDto
import com.james.crm.api.modules.people.data.dto.other.LocationDto
import com.james.crm.api.modules.team.domain.Team
import jakarta.validation.constraints.Min
import jakarta.validation.constraints.NotBlank


data class TeamDetailDto(
    @NotBlank
    var title: String,

    var manager: ManagerDto?,

    @Min(0)
    var budget: Double = 0.00,
) {

    var location: LocationDto? = null

    companion object : Mapper<TeamDetailDto, Team> {
        override fun toEntity(request: TeamDetailDto): Team {
            return Team(
                title = request.title,
                budget = request.budget,
                manager = request.manager?.let { ManagerDto.toEntity(it) }
            )
        }

        override fun toRequest(entity: Team): TeamDetailDto {
            return TeamDetailDto(
                title = entity.title,
                manager = entity.manager?.let { ManagerDto.toTrimRequest(it) },
                budget = entity.budget,
            ).apply { location = entity.location?.let { LocationDto.toRequest(it) } }
        }

    }
}