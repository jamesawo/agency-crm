/*
 * @Author: james.aworo
 * @Date: 11/13/23
 *
 * @Project: agent-crm
 */

package com.james.crm.api.modules.pipeline.data.usecase.implementation.stage

import com.james.crm.api.core.annotation.Usecase
import com.james.crm.api.core.common.ApiResponse
import com.james.crm.api.modules.pipeline.data.dto.StageDto
import com.james.crm.api.modules.pipeline.data.usecase.contract.stage.IAddStagesUsecase
import org.springframework.http.ResponseEntity

@Usecase
class AddStagesUsecaseImpl : IAddStagesUsecase {
    
    override fun execute(input: StageDto): ResponseEntity<ApiResponse<StageDto>> {
        TODO("Not yet implemented")
    }
}
