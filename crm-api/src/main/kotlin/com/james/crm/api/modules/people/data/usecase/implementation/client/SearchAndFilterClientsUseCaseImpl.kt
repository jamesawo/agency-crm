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
import com.james.crm.api.core.util.Util.Companion.successResponse
import com.james.crm.api.modules.people.data.dto.client.ClientDto
import com.james.crm.api.modules.people.data.dto.client.SearchCriteriaDto
import com.james.crm.api.modules.people.data.usecase.contract.client.ISearchAndFilterClientsUsecase
import com.james.crm.api.modules.people.domain.model.Client
import com.james.crm.api.modules.people.domain.repository.ClientDataRepository
import org.springframework.http.HttpStatus.INTERNAL_SERVER_ERROR
import org.springframework.http.HttpStatus.OK
import org.springframework.http.ResponseEntity


@Usecase
class SearchAndFilterClientsUseCaseImpl(
    private val clientRepository: ClientDataRepository
) : ISearchAndFilterClientsUsecase {

    override fun execute(input: SearchCriteriaDto): ResponseEntity<ApiResponse<List<ClientDto>>> {
        return try {
            val list = searchAndFilterClients(input).map { ClientDto.toTrimRequest(it) }
            successResponse(OK, list)
        } catch (ex: Exception) {
            errorResponse(INTERNAL_SERVER_ERROR, CatchableError(INTERNAL_SERVER_ERROR, ex))
        }
    }

    fun searchAndFilterClients(input: SearchCriteriaDto): List<Client> {
        //todo:: implement Specification search
        return emptyList()
    }
}
