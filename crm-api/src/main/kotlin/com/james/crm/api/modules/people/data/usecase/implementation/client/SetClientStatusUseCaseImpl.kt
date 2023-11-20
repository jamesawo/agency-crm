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
import com.james.crm.api.modules.people.data.usecase.contract.client.ISetClientStatusUsecase
import com.james.crm.api.modules.people.domain.enums.ClientStatus
import com.james.crm.api.modules.people.domain.repository.ClientDataRepository
import org.springframework.http.HttpStatus.*
import org.springframework.http.ResponseEntity

@Usecase
class SetClientStatusUseCaseImpl(
    private val clientRepository: ClientDataRepository
) : ISetClientStatusUsecase {

    override fun execute(input: Pair<String, ClientStatus>): ResponseEntity<ApiResponse<Boolean>> {
        return try {
            clientRepository.findById(input.first).map { client ->
                client.status = input.second
                clientRepository.save(client)
                successResponse(OK, true)
            }.orElse(errorResponse(NOT_FOUND, notFoundMessageAsList("client")))
        } catch (ex: Exception) {
            errorResponse(INTERNAL_SERVER_ERROR, CatchableError(INTERNAL_SERVER_ERROR, ex))
        }
    }
}
