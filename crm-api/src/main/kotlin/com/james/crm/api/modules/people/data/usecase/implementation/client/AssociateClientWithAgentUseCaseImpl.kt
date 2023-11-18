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
import com.james.crm.api.modules.people.data.usecase.contract.client.IAssociateClientWithAgentUsecase
import com.james.crm.api.modules.people.domain.repository.AgentDataRepository
import com.james.crm.api.modules.people.domain.repository.ClientDataRepository
import org.springframework.http.HttpStatus
import org.springframework.http.HttpStatus.INTERNAL_SERVER_ERROR
import org.springframework.http.ResponseEntity

@Usecase
class AssociateClientWithAgentUseCaseImpl(
    private val clientDataRepository: ClientDataRepository,
    private val agentRepository: AgentDataRepository
) : IAssociateClientWithAgentUsecase {

    override fun execute(input: Pair<String, String>): ResponseEntity<ApiResponse<Boolean>> {
        return try {
            clientDataRepository.findById(input.first).flatMap { client ->
                agentRepository.findById(input.second).map { agent ->
                    client.agent = agent
                    clientDataRepository.save(client)
                    successResponse(HttpStatus.OK, true)
                }
            }.orElse(errorResponse(HttpStatus.NOT_FOUND, notFoundMessageAsList("client / agent")))
        } catch (ex: Exception) {
            errorResponse(INTERNAL_SERVER_ERROR, CatchableError(INTERNAL_SERVER_ERROR, ex))
        }
    }
}
