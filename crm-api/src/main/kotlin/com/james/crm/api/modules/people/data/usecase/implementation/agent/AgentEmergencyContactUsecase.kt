/*
 * @Author: james.aworo
 * @Date: 11/8/23
 *
 * @Project: agent-crm
 */

package com.james.crm.api.modules.people.data.usecase.implementation.agent

import com.james.crm.api.core.annotation.Usecase
import com.james.crm.api.core.common.ApiResponse
import com.james.crm.api.core.util.Util.Companion.errorResponse
import com.james.crm.api.core.util.Util.Companion.notFoundMessageAsList
import com.james.crm.api.core.util.Util.Companion.successResponse
import com.james.crm.api.modules.people.data.dto.EmergencyContactDto
import com.james.crm.api.modules.people.data.usecase.contract.agent.IAgentEmergencyContactUsecase
import com.james.crm.api.modules.people.domain.repository.AgentDataRepository
import org.springframework.http.HttpStatus.NOT_FOUND
import org.springframework.http.HttpStatus.OK
import org.springframework.http.ResponseEntity

@Usecase
class AgentEmergencyContactUsecase(
    private val repository: AgentDataRepository
) : IAgentEmergencyContactUsecase {
    override fun getEmergencyContact(agentId: String): ResponseEntity<ApiResponse<EmergencyContactDto>> {
        return repository.findById(agentId).map {
            val dto = it.emergencyContact.let { it1 -> EmergencyContactDto.toRequest(it1) }
            successResponse(OK, dto.apply { id = null })
        }.orElse(errorResponse(NOT_FOUND, notFoundMessageAsList("agent")))
    }

    override fun updateEmergencyContact(
        agentId: String,
        contactDto: EmergencyContactDto
    ): ResponseEntity<ApiResponse<Boolean>> {
        return repository.findById(agentId).map {
            it.emergencyContact = EmergencyContactDto.toEntity(contactDto.apply { id = it.emergencyContact.id })
            repository.save(it)
            successResponse(OK, true)
        }.orElse(errorResponse(NOT_FOUND, notFoundMessageAsList("agent")))
    }
}