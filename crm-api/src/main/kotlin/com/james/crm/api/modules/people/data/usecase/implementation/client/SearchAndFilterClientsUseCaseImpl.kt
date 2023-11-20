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
import com.james.crm.api.modules.people.data.dto.client.SearchCriteriaDto
import com.james.crm.api.modules.people.data.usecase.contract.client.ISearchAndFilterClientsUsecase
import com.james.crm.api.modules.people.domain.model.Client
import com.james.crm.api.modules.people.domain.repository.ClientDataRepository
import org.springframework.data.domain.Pageable
import org.springframework.http.ResponseEntity


@Usecase
class SearchAndFilterClientsUseCaseImpl(
    private val clientRepository: ClientDataRepository
) : ISearchAndFilterClientsUsecase {

    fun searchAndFilterClients(input: SearchCriteriaDto): List<Client> {
        //todo:: implement Specification search
        return emptyList()
    }

    override fun execute(input: Pair<Pageable, SearchCriteriaDto>): ResponseEntity<ApiResponse<Paginate<ClientDto>>> {
        TODO("Not yet implemented")
    }
}
