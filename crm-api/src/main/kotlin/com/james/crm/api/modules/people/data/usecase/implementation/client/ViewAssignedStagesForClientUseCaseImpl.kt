/*
 * @Author: james.aworo
 * @Date: 11/18/23
 *
 * @Project: agent-crm
 */

package com.james.crm.api.modules.people.data.usecase.implementation.client

import com.james.crm.api.core.annotation.Usecase
import com.james.crm.api.core.common.ApiResponse
import com.james.crm.api.core.common.CatchableError
import com.james.crm.api.core.util.Util.Companion.errorResponse
import com.james.crm.api.core.util.Util.Companion.notFoundMessageAsList
import com.james.crm.api.core.util.Util.Companion.successResponse
import com.james.crm.api.modules.people.data.dto.client.SearchCriteriaDto
import com.james.crm.api.modules.people.data.usecase.contract.client.IViewAssignedStagesForClientUsecase
import com.james.crm.api.modules.people.domain.repository.ClientDataRepository
import com.james.crm.api.modules.pipeline.data.dto.StageDto
import org.springframework.data.domain.PageRequest
import org.springframework.http.HttpStatus.*
import org.springframework.http.ResponseEntity


@Usecase
class ViewAssignedStagesForClientUseCaseImpl(
    private val clientRepository: ClientDataRepository
) : IViewAssignedStagesForClientUsecase {

    override fun execute(input: Pair<PageRequest, SearchCriteriaDto>): ResponseEntity<ApiResponse<List<StageDto>>> {
        return try {
            clientRepository.findById(input).map { client ->
                val assignedStages = client.task?.pipeline?.stages ?: emptyList()
                val list = assignedStages.map { StageDto.toTrimRequest(it) }
                successResponse(OK, list)
            }.orElse(errorResponse(NOT_FOUND, notFoundMessageAsList("client")))
        } catch (ex: Exception) {
            errorResponse(INTERNAL_SERVER_ERROR, CatchableError(INTERNAL_SERVER_ERROR, ex))
        }
    }
}
