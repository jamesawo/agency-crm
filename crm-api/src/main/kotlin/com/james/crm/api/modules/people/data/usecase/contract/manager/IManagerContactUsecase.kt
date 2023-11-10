/*
 * @Author: james.aworo
 * @Date: 11/8/23
 *
 * @Project: agent-crm
 */

package com.james.crm.api.modules.people.data.usecase.contract.manager

import com.james.crm.api.modules.people.data.dto.ContactDto
import org.springframework.http.ResponseEntity

interface IManagerContactUsecase {
    fun getContact(managerId: String): ResponseEntity<ContactDto>
    fun updateContact(managerId: String, contactDto: ContactDto): ResponseEntity<ContactDto>
}
