/*
 * @Author: james.aworo
 * @Date: 11/13/23
 *
 * @Project: agent-crm
 */

package com.james.crm.api.modules.pipeline.data.usecase.implementation.pipeline

import com.james.crm.api.core.annotation.Usecase
import com.james.crm.api.core.common.ApiResponse
import com.james.crm.api.core.util.Util
import com.james.crm.api.core.util.Util.Companion.notFoundMessageAsList
import com.james.crm.api.core.util.Util.Companion.successResponse
import com.james.crm.api.modules.pipeline.data.dto.PipelineDto
import com.james.crm.api.modules.pipeline.data.dto.PipelineDto.Companion.toTrimRequest
import com.james.crm.api.modules.pipeline.data.repository.PipelineDataRepository
import com.james.crm.api.modules.pipeline.data.usecase.contract.pipeline.IGetPipelineUsecase
import org.springframework.http.HttpStatus.NOT_FOUND
import org.springframework.http.HttpStatus.OK
import org.springframework.http.ResponseEntity

@Usecase
class GetPipelineUsecaseImpl(
    private val pipelineRepo: PipelineDataRepository
) : IGetPipelineUsecase {
    override fun execute(input: String): ResponseEntity<ApiResponse<PipelineDto>> {
        return pipelineRepo.findById(input).map { pipeline ->
            successResponse(OK, toTrimRequest(pipeline))
        }.orElse(Util.errorResponse(NOT_FOUND, notFoundMessageAsList("pipeline")))
    }
}