/*
 * @Author: james.aworo
 * @Date: 11/8/23
 *
 * @Project: agent-crm
 */

package com.james.crm.api.modules.people.data.usecase.implementation.agent

import com.james.crm.api.core.annotation.Usecase
import com.james.crm.api.core.common.ApiResponse
import com.james.crm.api.core.common.ErrorResponse
import com.james.crm.api.core.common.SuccessResponse
import com.james.crm.api.modules.people.data.dto.ContactDto
import com.james.crm.api.modules.people.data.usecase.contract.agent.IAgentContactUsecase
import com.james.crm.api.modules.people.domain.repository.AgentDataRepository
import org.springframework.http.HttpStatus.*
import org.springframework.http.ResponseEntity

@Usecase
class AgentContactUsecase(
    private val repository: AgentDataRepository
) : IAgentContactUsecase {
    override fun getContact(agentId: String): ResponseEntity<ApiResponse<ContactDto>> {
        return repository.findById(agentId).map {
            val response: ApiResponse<ContactDto> = SuccessResponse(OK, ContactDto.toTrimmedRequest(it.contact))
            ResponseEntity.ok().body(response)
        }.orElse(
            ResponseEntity.status(NOT_FOUND).body(ErrorResponse(NOT_FOUND, listOf("Invalid agent id")))
        )
    }

    override fun updateContact(agentId: String, contactDto: ContactDto): ResponseEntity<ApiResponse<ContactDto>> {
        return try {
            return repository.findById(agentId).map {
                it.contact = ContactDto.toEntity(contactDto.apply { id = it.contact.id })
                val response: ApiResponse<ContactDto> =
                    SuccessResponse(OK, ContactDto.toTrimmedRequest(repository.save(it).contact))
                ResponseEntity.status(OK).body(response)
            }.orElse(ResponseEntity.status(NOT_FOUND).body(ErrorResponse(NOT_FOUND, listOf("Invalid agent id"))))
        } catch (ex: Exception) {
            ResponseEntity.status(INTERNAL_SERVER_ERROR)
                .body(ErrorResponse(INTERNAL_SERVER_ERROR, listOf(ex.localizedMessage)))
        }
    }

}