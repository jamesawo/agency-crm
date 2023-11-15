/*
 * @Author: james.aworo
 * @Date: 11/13/23
 *
 * @Project: agent-crm
 */

package com.james.crm.api.modules.pipeline.data.usecase.implementation.pipeline

import com.james.crm.api.core.annotation.Usecase
import com.james.crm.api.core.common.ApiResponse
import com.james.crm.api.core.common.CatchableError
import com.james.crm.api.core.util.Util.Companion.errorResponse
import com.james.crm.api.core.util.Util.Companion.successResponse
import com.james.crm.api.modules.pipeline.data.dto.PipelineDto
import com.james.crm.api.modules.pipeline.data.repository.PipelineDataRepository
import com.james.crm.api.modules.pipeline.data.usecase.contract.pipeline.ICreatePipelineUsecase
import org.springframework.http.HttpStatus.CREATED
import org.springframework.http.HttpStatus.INTERNAL_SERVER_ERROR
import org.springframework.http.ResponseEntity

@Usecase
class CreatePipelineUsecaseImpl(
    private val pipelineDataRepository: PipelineDataRepository
) : ICreatePipelineUsecase {

    override fun execute(input: PipelineDto): ResponseEntity<ApiResponse<PipelineDto>> {
        return try {
            val pipeline = pipelineDataRepository.save(PipelineDto.toEntity(input))
            successResponse(CREATED, PipelineDto.toTrimRequest(pipeline))
        } catch (ex: Exception) {
            errorResponse(INTERNAL_SERVER_ERROR, CatchableError(INTERNAL_SERVER_ERROR, ex))
        }
    }
}