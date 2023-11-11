/*
 * @Author: james.aworo
 * @Date: 11/8/23
 *
 * @Project: agent-crm
 */

package com.james.crm.api.modules.people.data.usecase.implementation.agent

import com.james.crm.api.core.annotation.Usecase
import com.james.crm.api.modules.people.data.dto.EmergencyContactDto
import com.james.crm.api.modules.people.data.usecase.contract.agent.IAgentEmergencyContactUsecase
import com.james.crm.api.modules.people.domain.repository.AgentDataRepository
import org.springframework.http.ResponseEntity

@Usecase
class AgentEmergencyContactUsecase(
    private val repository: AgentDataRepository
) : IAgentEmergencyContactUsecase {
    override fun getEmergencyContact(agentId: String): ResponseEntity<EmergencyContactDto> {
        return repository.findById(agentId).map {
            ResponseEntity.ok().body(it.emergencyContact.let { it1 -> EmergencyContactDto.toRequest(it1) })
        }.orElse(ResponseEntity.notFound().build())
    }

    override fun updateEmergencyContact(
        agentId: String,
        contactDto: EmergencyContactDto
    ): ResponseEntity<EmergencyContactDto> {
        return repository.findById(agentId).map {
            it.emergencyContact = EmergencyContactDto.toEntity(contactDto.apply { id = it.emergencyContact.id })
            ResponseEntity.ok(EmergencyContactDto.toRequest(repository.save(it).emergencyContact))
        }.orElse(ResponseEntity.notFound().build())


    }
}