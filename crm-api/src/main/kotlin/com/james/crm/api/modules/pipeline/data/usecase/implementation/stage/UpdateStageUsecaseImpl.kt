/*
 * @Author: james.aworo
 * @Date: 11/13/23
 *
 * @Project: agent-crm
 */

package com.james.crm.api.modules.pipeline.data.usecase.implementation.stage

import com.james.crm.api.core.annotation.Usecase
import com.james.crm.api.core.common.ApiResponse
import com.james.crm.api.core.util.Util
import com.james.crm.api.modules.pipeline.data.dto.StageDto
import com.james.crm.api.modules.pipeline.data.repository.StageDataRepository
import com.james.crm.api.modules.pipeline.data.usecase.contract.stage.IUpdateStageUsecase
import com.james.crm.api.modules.pipeline.domain.Pipeline
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity

@Usecase
class UpdateStageUsecaseImpl(
    private val stageRepo: StageDataRepository
) : IUpdateStageUsecase {
    override fun execute(input: Pair<String, StageDto>): ResponseEntity<ApiResponse<Boolean>> {
        return stageRepo.findById(input.first).map {
            val stage = StageDto.toEntity(input.second).apply { id = it.id; pipeline = Pipeline(it.pipeline.id) }
            stageRepo.save(stage)
            Util.successResponse(HttpStatus.OK, true)
        }.orElse(Util.errorResponse(HttpStatus.NOT_FOUND, Util.notFoundMessageAsList("stage")))
    }
}