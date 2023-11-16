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
import com.james.crm.api.modules.pipeline.data.dto.StageDto.Companion.toRequest
import com.james.crm.api.modules.pipeline.data.repository.StageDataRepository
import com.james.crm.api.modules.pipeline.data.usecase.contract.stage.IGetStageUsecase
import org.springframework.http.HttpStatus.NOT_FOUND
import org.springframework.http.HttpStatus.OK
import org.springframework.http.ResponseEntity

@Usecase
class GetStageUsecaseImpl(
    private val stageRepo: StageDataRepository
) : IGetStageUsecase {
    override fun execute(input: String): ResponseEntity<ApiResponse<StageDto>> {
        return stageRepo.findById(input).map { successResponse(OK, toRequest(it)) }
            .orElse(errorResponse(NOT_FOUND, notFoundMessageAsList("stage")))
    }
}