/*
 * @Author: james.aworo
 * @Date: 11/19/23
 *
 * @Project: agent-crm
 */

package com.james.crm.api.modules.people.data.usecase.implementation.client

import com.james.crm.api.core.annotation.Usecase
import com.james.crm.api.core.common.ApiResponse
import com.james.crm.api.core.util.Util
import com.james.crm.api.core.util.Util.Companion.errorResponse
import com.james.crm.api.core.util.Util.Companion.successResponse
import com.james.crm.api.modules.people.data.dto.agent.AgentDto
import com.james.crm.api.modules.people.data.usecase.contract.client.IRetrieveAgentAssociatedWithClientUsecase
import com.james.crm.api.modules.people.domain.repository.ClientDataRepository
import org.springframework.http.HttpStatus.NOT_FOUND
import org.springframework.http.HttpStatus.OK
import org.springframework.http.ResponseEntity

@Usecase
class RetrieveAgentAssociatedWithClientUsecaseImpl(
    private val clientRepository: ClientDataRepository
) : IRetrieveAgentAssociatedWithClientUsecase {
    override fun execute(input: String): ResponseEntity<ApiResponse<AgentDto>> {
        return clientRepository.findById(input).map { client ->
            successResponse(OK, AgentDto.toTrimRequest(client.agent))
        }.orElse(errorResponse(NOT_FOUND, Util.notFoundMessageAsList("client")))
    }
}