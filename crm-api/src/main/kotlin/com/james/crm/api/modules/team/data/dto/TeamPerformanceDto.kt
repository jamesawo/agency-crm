/*
 * @Author: james.aworo
 * @Date: 11/11/23
 *
 * @Project: agent-crm
 */

package com.james.crm.api.modules.team.data.dto

import com.james.crm.api.core.common.Mapper
import com.james.crm.api.modules.team.domain.Team


data class TeamPerformanceDto(
    var id: String?,
) {

    companion object : Mapper<TeamPerformanceDto, Team> {
        override fun toEntity(request: TeamPerformanceDto): Team {
            return Team(id = request.id)
        }

        override fun toRequest(entity: Team): TeamPerformanceDto {
            return TeamPerformanceDto(
                id = entity.id,
            )
        }
    }
}