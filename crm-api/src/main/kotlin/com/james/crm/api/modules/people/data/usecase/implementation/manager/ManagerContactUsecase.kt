/*
 * @Author: james.aworo
 * @Date: 11/8/23
 *
 * @Project: agent-crm
 */

package com.james.crm.api.modules.people.data.usecase.implementation.manager

import com.james.crm.api.core.annotation.Usecase
import com.james.crm.api.modules.people.data.dto.ContactDto
import com.james.crm.api.modules.people.data.usecase.contract.manager.IManagerContactUsecase
import com.james.crm.api.modules.people.domain.repository.ManagerDataRepository
import org.springframework.http.ResponseEntity

@Usecase
class ManagerContactUsecase(
    private val repository: ManagerDataRepository
) : IManagerContactUsecase {
    override fun getContact(managerId: String): ResponseEntity<ContactDto> {
        return repository.findById(managerId).map {
            ResponseEntity.ok().body(ContactDto.toTrimRequest(it.contact))
        }.orElse(ResponseEntity.notFound().build())
    }

    override fun updateContact(managerId: String, contactDto: ContactDto): ResponseEntity<ContactDto> {
        return repository.findById(managerId).map {
            it.contact = ContactDto.toEntity(contactDto.apply { id = it.contact.id })
            ResponseEntity.ok(ContactDto.toTrimRequest(repository.save(it).contact))
        }.orElse(ResponseEntity.notFound().build())
    }
}