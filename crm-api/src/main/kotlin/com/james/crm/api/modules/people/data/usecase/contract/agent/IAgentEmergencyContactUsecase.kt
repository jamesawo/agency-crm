/*
 * @Author: james.aworo
 * @Date: 11/8/23
 *
 * @Project: agent-crm
 */

package com.james.crm.api.modules.people.data.usecase.contract.agent

import com.james.crm.api.modules.people.data.dto.ContactDto
import org.springframework.http.ResponseEntity

interface IAgentEmergencyContactUsecase {
    fun getEmergencyContact(agentId: String): ResponseEntity<ContactDto>
    fun updateEmergencyContact(agentId: String, contactDto: ContactDto): ResponseEntity<ContactDto>
}