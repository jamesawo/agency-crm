/*
 * @Author: james.aworo
 * @Date: 11/19/23
 *
 * @Project: agent-crm
 */

package com.james.crm.api.modules.people.data.usecase.implementation.client

import com.james.crm.api.core.annotation.Usecase
import com.james.crm.api.core.common.ApiResponse
import com.james.crm.api.core.common.CatchableError
import com.james.crm.api.core.util.Util.Companion.errorResponse
import com.james.crm.api.core.util.Util.Companion.successResponse
import com.james.crm.api.modules.people.data.dto.agent.AgentDto
import com.james.crm.api.modules.people.data.usecase.contract.client.IGetClientAssociatedAgent
import com.james.crm.api.modules.people.domain.repository.ClientDataRepository
import org.springframework.http.HttpStatus.INTERNAL_SERVER_ERROR
import org.springframework.http.HttpStatus.OK
import org.springframework.http.ResponseEntity

@Usecase
class GetClientAssociatedAgentImpl(
    private val clientRepository: ClientDataRepository
) : IGetClientAssociatedAgent {
    override fun execute(input: String): ResponseEntity<ApiResponse<AgentDto>> {
        return try {
            clientRepository.findById(input)
                .map { successResponse(OK, AgentDto.toTrimRequest(it.agent)) }
                .orElse(successResponse(OK, AgentDto()))
        } catch (ex: Exception) {
            errorResponse(INTERNAL_SERVER_ERROR, CatchableError(INTERNAL_SERVER_ERROR, ex))
        }

    }
}