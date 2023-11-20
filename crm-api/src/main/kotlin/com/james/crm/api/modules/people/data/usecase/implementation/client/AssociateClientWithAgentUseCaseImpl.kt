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
import com.james.crm.api.modules.people.data.usecase.contract.client.IAssociateClientWithAgentUsecase
import com.james.crm.api.modules.people.domain.repository.AgentDataRepository
import com.james.crm.api.modules.people.domain.repository.ClientDataRepository
import org.springframework.data.domain.PageRequest
import org.springframework.http.HttpStatus
import org.springframework.http.HttpStatus.INTERNAL_SERVER_ERROR
import org.springframework.http.HttpStatus.NOT_FOUND
import org.springframework.http.ResponseEntity

@Usecase
class AssociateClientWithAgentUseCaseImpl(
    private val clientDataRepository: ClientDataRepository,
    private val agentRepository: AgentDataRepository
) : IAssociateClientWithAgentUsecase {

    override fun execute(input: Pair<PageRequest, SearchCriteriaDto>): ResponseEntity<ApiResponse<Boolean>> {
        return try {
            val clientOptional = clientDataRepository.findById(input.first)
            val agentOptional = agentRepository.findById(input.second)
            clientOptional.flatMap { client ->
                agentOptional.map { agent ->
                    client.agent = agent
                    clientDataRepository.save(client)
                    successResponse(HttpStatus.OK, true)
                }
            }.orElse(
                errorResponse(
                    NOT_FOUND,
                    notFoundMessageAsList(
                        when {
                            clientOptional.isEmpty -> "Client"
                            agentOptional.isEmpty -> "Agent"
                            else -> "Client and Agent"
                        }
                    )
                )
            )
        } catch (ex: Exception) {
            errorResponse(INTERNAL_SERVER_ERROR, CatchableError(INTERNAL_SERVER_ERROR, ex))
        }
    }
}
