/*
 * @Author: james.aworo
 * @Date: 11/8/23
 *
 * @Project: agent-crm
 */

package com.james.crm.api.modules.people.data.usecase.contract.manager

import com.james.crm.api.core.common.ApiResponse
import com.james.crm.api.modules.people.data.dto.ContactDto
import org.springframework.http.ResponseEntity

interface IManagerContactUsecase {
    fun getContact(managerId: String): ResponseEntity<ApiResponse<ContactDto>>
    fun updateContact(managerId: String, contactDto: ContactDto): ResponseEntity<ApiResponse<ContactDto>>
}
