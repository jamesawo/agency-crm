/*
 * @Author: james.aworo
 * @Date: 11/8/23
 *
 * @Project: agent-crm
 */

package com.james.crm.api.modules.people.data.usecase.implementation.agent

import com.james.crm.api.core.annotation.Usecase
import com.james.crm.api.core.common.ApiResponse
import com.james.crm.api.core.common.CatchableError
import com.james.crm.api.core.util.Util.Companion.errorResponse
import com.james.crm.api.core.util.Util.Companion.notFoundMessageAsList
import com.james.crm.api.core.util.Util.Companion.successResponse
import com.james.crm.api.modules.people.data.dto.other.ContactDto
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
            successResponse(OK, ContactDto.toTrimRequest(it.contact).apply { id = null })
        }.orElse(errorResponse(NOT_FOUND, notFoundMessageAsList("agent")))
    }

    override fun updateContact(agentId: String, contactDto: ContactDto): ResponseEntity<ApiResponse<Boolean>> {
        return try {
            return repository.findById(agentId).map {
                it.contact = ContactDto.toEntity(contactDto.apply { id = it.contact.id })
                repository.save(it)
                successResponse(OK, true)
            }.orElse(errorResponse(NOT_FOUND, notFoundMessageAsList("agent")))
        } catch (ex: Exception) {
            errorResponse(INTERNAL_SERVER_ERROR, CatchableError(INTERNAL_SERVER_ERROR, ex))
        }
    }

}