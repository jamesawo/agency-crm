/*
 * @Author: james.aworo
 * @Date: 11/30/23
 *
 * @Project: agent-crm
 */

package com.james.crm.api.modules.pipeline.data.usecase.implementation.pipeline

import com.james.crm.api.core.annotation.Usecase
import com.james.crm.api.core.common.ApiResponse
import com.james.crm.api.core.common.CatchableError
import com.james.crm.api.core.common.PagePayload
import com.james.crm.api.core.common.Paginate
import com.james.crm.api.core.util.Util.Companion.errorResponse
import com.james.crm.api.core.util.Util.Companion.successResponse
import com.james.crm.api.modules.pipeline.data.dto.PipelineDto
import com.james.crm.api.modules.pipeline.data.dto.PipelineSearchParams
import com.james.crm.api.modules.pipeline.data.repository.PipelineDataRepository
import com.james.crm.api.modules.pipeline.data.specification.PipelineSpecification.Companion.criteria
import com.james.crm.api.modules.pipeline.data.usecase.contract.pipeline.ISearchPipelineUsecase
import org.springframework.data.domain.PageImpl
import org.springframework.http.HttpStatus.INTERNAL_SERVER_ERROR
import org.springframework.http.HttpStatus.OK
import org.springframework.http.ResponseEntity

@Usecase
class SearchPipelineUsecase(
    val pipelineRepository: PipelineDataRepository
) : ISearchPipelineUsecase {

    override fun execute(input: Pair<PipelineSearchParams, PagePayload>): ResponseEntity<ApiResponse<Paginate<PipelineDto>>> {
        return try {
            val pageRequest = input.second.toPageRequest("title")
            val page = pipelineRepository.findAll(criteria(input.first), pageRequest)
            val dtoList = page.content.map { PipelineDto.toTrimRequest(it) }
            successResponse(OK, Paginate.fromPage(PageImpl(dtoList, pageRequest, page.totalElements)))
        } catch (ex: Exception) {
            errorResponse(INTERNAL_SERVER_ERROR, CatchableError(INTERNAL_SERVER_ERROR, ex))
        }
    }
}