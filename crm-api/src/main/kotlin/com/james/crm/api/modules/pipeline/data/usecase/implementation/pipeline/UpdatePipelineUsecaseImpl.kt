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
import com.james.crm.api.core.util.Util.Companion.notFoundMessageAsList
import com.james.crm.api.core.util.Util.Companion.successResponse
import com.james.crm.api.modules.pipeline.data.dto.PipelineDto
import com.james.crm.api.modules.pipeline.data.repository.PipelineDataRepository
import com.james.crm.api.modules.pipeline.data.usecase.contract.pipeline.IUpdatePipelineUsecase
import org.springframework.http.HttpStatus.INTERNAL_SERVER_ERROR
import org.springframework.http.HttpStatus.OK
import org.springframework.http.ResponseEntity

@Usecase
class UpdatePipelineUsecaseImpl(
    private val pipelineRepo: PipelineDataRepository
) : IUpdatePipelineUsecase {
    override fun execute(input: Pair<String, PipelineDto>): ResponseEntity<ApiResponse<Boolean>> {
        return try {
            pipelineRepo.findById(input.first).map { pipeline ->
                val (_, pTitle, pHierarchy) = input.second
                pipelineRepo.save(pipeline.apply { title = pTitle; hierarchy = pHierarchy })
                successResponse(OK, true)
            }.orElse(errorResponse(OK, notFoundMessageAsList("Pipeline")))
        } catch (ex: Exception) {
            errorResponse(INTERNAL_SERVER_ERROR, CatchableError(INTERNAL_SERVER_ERROR, ex))
        }
    }
}