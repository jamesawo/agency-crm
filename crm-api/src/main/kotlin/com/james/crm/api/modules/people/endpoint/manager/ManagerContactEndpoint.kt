package com.james.crm.api.modules.people.endpoint.manager

import com.james.crm.api.core.constant.Route.Companion.API_VERSION
import com.james.crm.api.modules.people.data.dto.ContactDto
import com.james.crm.api.modules.people.data.usecase.contract.manager.IManagerContactUsecase
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("$API_VERSION/managers/{managerId}/contact")
class ManagerContactEndpoint(
    private val contactUsecase: IManagerContactUsecase
) {
    @GetMapping
    fun getContact(@PathVariable managerId: String): ResponseEntity<ContactDto> = contactUsecase.getContact(managerId)

    @PutMapping()
    fun updateContact(
        @RequestBody contactDto: ContactDto,
        @PathVariable managerId: String
    ): ResponseEntity<ContactDto> = contactUsecase.updateContact(managerId, contactDto)

}