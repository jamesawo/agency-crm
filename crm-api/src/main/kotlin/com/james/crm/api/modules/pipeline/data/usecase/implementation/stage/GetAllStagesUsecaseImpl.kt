/*
 * @Author: james.aworo
 * @Date: 11/13/23
 *
 * @Project: agent-crm
 */

package com.james.crm.api.modules.pipeline.data.usecase.implementation.stage

import com.james.crm.api.core.annotation.Usecase
import com.james.crm.api.core.common.ApiResponse
import com.james.crm.api.core.util.Util.Companion.errorResponse
import com.james.crm.api.core.util.Util.Companion.notFoundMessageAsList
import com.james.crm.api.core.util.Util.Companion.successResponse
import com.james.crm.api.modules.pipeline.data.dto.StageDto
import com.james.crm.api.modules.pipeline.data.repository.PipelineDataRepository
import com.james.crm.api.modules.pipeline.data.repository.StageDataRepository
import com.james.crm.api.modules.pipeline.data.usecase.contract.stage.IGetAllStagesUsecase
import org.springframework.http.HttpStatus.NOT_FOUND
import org.springframework.http.HttpStatus.OK
import org.springframework.http.ResponseEntity

@Usecase
class GetAllStagesUsecaseImpl(
    private val pipelineRepo: PipelineDataRepository,
    private val stageRepo: StageDataRepository
) : IGetAllStagesUsecase {
    override fun execute(input: String): ResponseEntity<ApiResponse<List<StageDto>>> {
        return pipelineRepo.findById(input).map { pipeline ->
            val stageDtoList = pipeline.stages.filterNotNull().map { StageDto.toRequest(it) }
            successResponse(OK, stageDtoList)
        }.orElse(errorResponse(NOT_FOUND, notFoundMessageAsList("pipeline")))
    }
}