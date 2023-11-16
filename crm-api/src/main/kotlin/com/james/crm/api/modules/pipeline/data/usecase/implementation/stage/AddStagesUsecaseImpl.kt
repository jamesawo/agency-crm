/*
 * @Author: james.aworo
 * @Date: 11/13/23
 *
 * @Project: agent-crm
 */

package com.james.crm.api.modules.pipeline.data.usecase.implementation.stage

import com.james.crm.api.core.annotation.Usecase
import com.james.crm.api.core.common.ApiResponse
import com.james.crm.api.core.common.CatchableError
import com.james.crm.api.core.util.Util.Companion.errorResponse
import com.james.crm.api.core.util.Util.Companion.notFoundMessageAsList
import com.james.crm.api.core.util.Util.Companion.successResponse
import com.james.crm.api.modules.pipeline.data.dto.StageDto
import com.james.crm.api.modules.pipeline.data.repository.PipelineDataRepository
import com.james.crm.api.modules.pipeline.data.repository.StageDataRepository
import com.james.crm.api.modules.pipeline.data.usecase.contract.stage.IAddStagesUsecase
import org.springframework.http.HttpStatus.*
import org.springframework.http.ResponseEntity

@Usecase
class AddStagesUsecaseImpl(
    private val pipelineRepo: PipelineDataRepository,
    private val stageRepo: StageDataRepository
) : IAddStagesUsecase {

    override fun execute(input: Pair<String, StageDto>): ResponseEntity<ApiResponse<StageDto>> {
        return try {
            pipelineRepo.findById(input.first).map { it ->
                val stage = stageRepo.save(StageDto.toEntity(input.second).apply { pipeline = it })
                successResponse(CREATED, StageDto.toRequest(stage))
            }.orElse(
                errorResponse(NOT_FOUND, notFoundMessageAsList("pipeline"))
            )
        } catch (ex: Exception) {
            errorResponse(INTERNAL_SERVER_ERROR, CatchableError(INTERNAL_SERVER_ERROR, ex))
        }
    }
}
