/*
 * @Author: james.aworo
 * @Date: 11/8/23
 *
 * @Project: agent-crm
 */

package com.james.crm.api.modules.people.data.usecase.contract.agent

import com.james.crm.api.modules.people.data.dto.ContactDto
import org.springframework.http.ResponseEntity

interface IAgentContactUsecase {
    fun getContact(agentId: String): ResponseEntity<ContactDto>
    fun updateContact(agentId: String, contactDto: ContactDto): ResponseEntity<ContactDto>
}