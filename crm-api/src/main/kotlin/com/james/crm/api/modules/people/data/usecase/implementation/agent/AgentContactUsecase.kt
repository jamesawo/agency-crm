/*
 * @Author: james.aworo
 * @Date: 11/8/23
 *
 * @Project: agent-crm
 */

package com.james.crm.api.modules.people.data.usecase.implementation.agent

import com.james.crm.api.core.annotation.Usecase
import com.james.crm.api.modules.people.data.dto.ContactDto
import com.james.crm.api.modules.people.data.usecase.contract.agent.IAgentContactUsecase
import com.james.crm.api.modules.people.domain.repository.AgentDataRepository
import org.springframework.http.ResponseEntity

@Usecase
class AgentContactUsecase(
    private val repository: AgentDataRepository
) : IAgentContactUsecase {
    override fun getContact(agentId: String): ResponseEntity<ContactDto> {
        return repository.findById(agentId).map {
            ResponseEntity.ok().body(ContactDto.toTrimmedRequest(it.contact))
        }.orElse(ResponseEntity.notFound().build())
    }

    override fun updateContact(agentId: String, contactDto: ContactDto): ResponseEntity<ContactDto> {
        return repository.findById(agentId).map {
            it.contact = ContactDto.toEntity(contactDto.apply { id = it.contact.id })
            ResponseEntity.ok(ContactDto.toTrimmedRequest(repository.save(it).contact))
        }.orElse(ResponseEntity.notFound().build())
    }

}