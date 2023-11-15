/*
 * @Author: james.aworo
 * @Date: 11/13/23
 *
 * @Project: agent-crm
 */

package com.james.crm.api.modules.pipeline.data.usecase.implementation.pipeline

import com.james.crm.api.core.common.ApiResponse
import com.james.crm.api.core.common.CatchableError
import com.james.crm.api.core.common.Paginate
import com.james.crm.api.core.common.Paginate.Companion.fromPage
import com.james.crm.api.core.util.Util.Companion.errorResponse
import com.james.crm.api.core.util.Util.Companion.successResponse
import com.james.crm.api.modules.pipeline.data.dto.PipelineDto
import com.james.crm.api.modules.pipeline.data.repository.PipelineDataRepository
import com.james.crm.api.modules.pipeline.data.usecase.contract.pipeline.IGetAllPipelineUsecase
import org.springframework.data.domain.PageImpl
import org.springframework.data.domain.Pageable
import org.springframework.http.HttpStatus.INTERNAL_SERVER_ERROR
import org.springframework.http.HttpStatus.OK
import org.springframework.http.ResponseEntity

@com.james.crm.api.core.annotation.Usecase
class GetAllPipelineUsecaseImpl(
    private val pipelineRepository: PipelineDataRepository
) : IGetAllPipelineUsecase {
    override fun execute(input: Pageable): ResponseEntity<ApiResponse<Paginate<PipelineDto>>> {
        return try {
            val pipeLinePage = pipelineRepository.findAll(input)
            val dtoList = pipeLinePage.content.map { PipelineDto.toTrimRequest(it) }
            successResponse(
                OK, fromPage(PageImpl(dtoList, input, pipeLinePage.totalElements))
            )
        } catch (ex: Exception) {
            errorResponse(INTERNAL_SERVER_ERROR, CatchableError(INTERNAL_SERVER_ERROR, ex))
        }
    }
}