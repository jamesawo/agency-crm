/*
 * @Author: james.aworo
 * @Date: 11/13/23
 *
 * @Project: agent-crm
 */

package com.james.crm.api.modules.team.data.usecase.implementation

import com.james.crm.api.core.annotation.Usecase
import com.james.crm.api.core.common.ApiResponse
import com.james.crm.api.modules.team.data.dto.TeamPerformanceDto
import com.james.crm.api.modules.team.data.usecase.contract.IGetTeamPerformanceUsecase
import org.springframework.http.ResponseEntity

@Usecase
class GetTeamPerformanceUsecaseImpl : IGetTeamPerformanceUsecase {
    override fun execute(input: String): ResponseEntity<ApiResponse<TeamPerformanceDto>> {
        TODO("Get Team Performance is Not yet implemented")
    }
}