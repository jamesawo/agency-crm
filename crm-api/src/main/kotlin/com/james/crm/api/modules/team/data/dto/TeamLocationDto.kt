/*
 * @Author: james.aworo
 * @Date: 11/11/23
 *
 * @Project: agent-crm
 */

package com.james.crm.api.modules.team.data.dto

import com.james.crm.api.core.common.Mapper
import com.james.crm.api.modules.people.data.dto.LocationDto
import com.james.crm.api.modules.team.domain.Team


data class TeamLocationDto(
    var id: String?,
    var title: String,
    var location: LocationDto? = null
) {

    companion object : Mapper<TeamLocationDto, Team> {
        override fun toEntity(request: TeamLocationDto): Team {
            return Team(id = request.id)
        }

        override fun toRequest(entity: Team): TeamLocationDto {
            return TeamLocationDto(
                id = entity.id,
                title = entity.title,
                location = entity.location?.let { LocationDto.toRequest(it) }
            )
        }
    }
}