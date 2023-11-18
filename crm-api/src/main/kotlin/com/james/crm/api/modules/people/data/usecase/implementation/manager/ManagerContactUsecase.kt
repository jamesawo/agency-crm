/*
 * @Author: james.aworo
 * @Date: 11/8/23
 *
 * @Project: agent-crm
 */

package com.james.crm.api.modules.people.data.usecase.implementation.manager

import com.james.crm.api.core.annotation.Usecase
import com.james.crm.api.core.common.ApiResponse
import com.james.crm.api.core.util.Util
import com.james.crm.api.core.util.Util.Companion.errorResponse
import com.james.crm.api.core.util.Util.Companion.successResponse
import com.james.crm.api.modules.people.data.dto.other.ContactDto
import com.james.crm.api.modules.people.data.usecase.contract.manager.IManagerContactUsecase
import com.james.crm.api.modules.people.domain.repository.ManagerDataRepository
import org.springframework.http.HttpStatus.NOT_FOUND
import org.springframework.http.HttpStatus.OK
import org.springframework.http.ResponseEntity

@Usecase
class ManagerContactUsecase(
    private val repository: ManagerDataRepository
) : IManagerContactUsecase {
    override fun getContact(managerId: String): ResponseEntity<ApiResponse<ContactDto>> {
        return repository.findById(managerId).map {
            successResponse(OK, ContactDto.toTrimRequest(it.contact))
        }.orElse(errorResponse(NOT_FOUND, Util.notFoundMessageAsList("manager")))
    }

    override fun updateContact(managerId: String, contactDto: ContactDto): ResponseEntity<ApiResponse<ContactDto>> {
        return repository.findById(managerId).map {
            it.contact = ContactDto.toEntity(contactDto.apply { id = it.contact.id })
            successResponse(OK, ContactDto.toTrimRequest(repository.save(it).contact))
        }.orElse(errorResponse(NOT_FOUND, Util.notFoundMessageAsList("manager")))
    }
}