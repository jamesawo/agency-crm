/*
 * @Author: james.aworo
 * @Date: 11/13/23
 *
 * @Project: agent-crm
 */

package com.james.crm.api.modules.team.data.usecase.implementation

import com.james.crm.api.core.annotation.Usecase
import com.james.crm.api.core.common.ApiResponse
import com.james.crm.api.modules.people.data.dto.LocationDto
import com.james.crm.api.modules.team.data.dto.TeamDetailDto
import com.james.crm.api.modules.team.data.usecase.contract.ISetTeamManagerUsecase
import org.springframework.http.ResponseEntity

@Usecase
class SetTeamManagerUsecase : ISetTeamManagerUsecase {
    override fun execute(input: Pair<String, LocationDto>): ResponseEntity<ApiResponse<TeamDetailDto>> {
        TODO("Not yet implemented")
    }
}