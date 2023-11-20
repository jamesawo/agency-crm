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
import com.james.crm.api.core.common.ResourceId
import com.james.crm.api.core.util.Util.Companion.errorResponse
import com.james.crm.api.core.util.Util.Companion.notFoundMessageAsList
import com.james.crm.api.core.util.Util.Companion.successResponse
import com.james.crm.api.modules.people.data.dto.client.ClientQuickDraftDto
import com.james.crm.api.modules.people.data.dto.client.SearchCriteriaDto
import com.james.crm.api.modules.people.data.usecase.contract.client.IClientQuickDraftUsecase
import com.james.crm.api.modules.people.domain.repository.AgentDataRepository
import com.james.crm.api.modules.people.domain.repository.ClientDataRepository
import org.springframework.data.domain.PageRequest
import org.springframework.http.HttpStatus.*
import org.springframework.http.ResponseEntity

@Usecase
class ClientQuickDraftUseCaseImpl(
    private val clientRepository: ClientDataRepository,
    private val agentRepository: AgentDataRepository
) : IClientQuickDraftUsecase {

    override fun execute(input: Pair<PageRequest, SearchCriteriaDto>): ResponseEntity<ApiResponse<ResourceId>> {
        return try {
            agentRepository.findById(input.first).map {
                val newClient = clientRepository.save(ClientQuickDraftDto.toEntity(input.second))
                successResponse(CREATED, ResourceId(newClient.id))
            }.orElse(errorResponse(NOT_FOUND, notFoundMessageAsList("agent")))
        } catch (ex: Exception) {
            errorResponse(INTERNAL_SERVER_ERROR, CatchableError(INTERNAL_SERVER_ERROR, ex))
        }
    }
}