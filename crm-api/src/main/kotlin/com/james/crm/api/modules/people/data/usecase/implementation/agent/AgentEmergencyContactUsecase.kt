/*
 * @Author: james.aworo
 * @Date: 11/8/23
 *
 * @Project: agent-crm
 */

package com.james.crm.api.modules.people.data.usecase.implementation.agent

import com.james.crm.api.core.annotation.Usecase
import com.james.crm.api.modules.people.data.dto.ContactDto
import com.james.crm.api.modules.people.data.usecase.contract.agent.IAgentEmergencyContactUsecase
import org.springframework.http.ResponseEntity

@Usecase
class AgentEmergencyContactUsecase : IAgentEmergencyContactUsecase {
    override fun getEmergencyContact(agentId: String): ResponseEntity<ContactDto> {
        TODO()
    }

    override fun updateEmergencyContact(agentId: String, contactDto: ContactDto): ResponseEntity<ContactDto> {
        TODO()
    }
}