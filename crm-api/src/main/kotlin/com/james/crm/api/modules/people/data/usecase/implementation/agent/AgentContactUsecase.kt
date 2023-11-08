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
import org.springframework.http.ResponseEntity

@Usecase
class AgentContactUsecase : IAgentContactUsecase {
    override fun getContact(agentId: String): ResponseEntity<ContactDto> {
        TODO()
    }

    override fun updateContact(agentId: String, contactDto: ContactDto): ResponseEntity<ContactDto> {
        TODO()
    }

}