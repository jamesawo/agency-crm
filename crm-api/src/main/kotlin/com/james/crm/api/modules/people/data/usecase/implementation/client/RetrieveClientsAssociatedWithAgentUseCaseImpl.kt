/*
 * @Author: james.aworo
 * @Date: 11/18/23
 *
 * @Project: agent-crm
 */

package com.james.crm.api.modules.people.data.usecase.implementation.client

import com.james.crm.api.core.annotation.Usecase
import com.james.crm.api.core.common.ApiResponse
import com.james.crm.api.core.common.Paginate
import com.james.crm.api.modules.people.data.dto.client.ClientDto
import com.james.crm.api.modules.people.data.usecase.contract.client.IRetrieveClientsAssociatedWithAgentUsecase
import com.james.crm.api.modules.people.domain.repository.ClientDataRepository
import org.springframework.data.domain.Pageable
import org.springframework.http.ResponseEntity

@Usecase
class RetrieveClientsAssociatedWithAgentUseCaseImpl(
    private val clientRepository: ClientDataRepository
) : IRetrieveClientsAssociatedWithAgentUsecase {

    override fun execute(input: Pair<String, Pageable>): ResponseEntity<ApiResponse<Paginate<ClientDto>>> {
        TODO()
    }
}
