/*
 * @Author: james.aworo
 * @Date: 11/21/23
 *
 * @Project: agent-crm
 */

package com.james.crm.api.modules.pipeline.data.usecase.implementation.pipeline

import com.james.crm.api.core.annotation.Usecase
import com.james.crm.api.core.common.ApiResponse
import com.james.crm.api.core.common.Paginate
import com.james.crm.api.modules.pipeline.data.dto.StageDto
import com.james.crm.api.modules.pipeline.data.usecase.contract.pipeline.IGetAllStageInPipelineUsecase
import org.springframework.data.domain.Pageable
import org.springframework.http.ResponseEntity

@Usecase
class GetAllStageInPipelineUsecaseImpl : IGetAllStageInPipelineUsecase {
    override fun execute(input: Pair<String, Pageable>): ResponseEntity<ApiResponse<Paginate<StageDto>>> {
        TODO("Not yet implemented")
    }

}