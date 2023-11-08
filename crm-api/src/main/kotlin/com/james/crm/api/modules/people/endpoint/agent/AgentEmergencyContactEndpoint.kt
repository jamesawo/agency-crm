/*
 * @Author: james.aworo
 * @Date: 11/8/23
 *
 * @Project: agent-crm
 */

package com.james.crm.api.modules.people.endpoint.agent

import com.james.crm.api.core.constant.Route
import com.james.crm.api.modules.people.data.dto.ContactDto
import com.james.crm.api.modules.people.data.usecase.contract.agent.IAgentEmergencyContactUsecase
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("${Route.BASE}/agents/{agentId}/emergency-contact")
class AgentEmergencyContactEndpoint(
    private val emergencyContactUsecase: IAgentEmergencyContactUsecase
) {

    // Emergency Contacts
    @GetMapping("/{id}/emergency-contact")
    fun getEmergencyContact(@PathVariable id: String, @PathVariable agentId: String): ResponseEntity<ContactDto> {
        return emergencyContactUsecase.getEmergencyContact(id)
    }

    @PutMapping("/{id}/emergency-contact")
    fun updateEmergencyContact(
        @PathVariable id: String,
        @RequestBody contactDto: ContactDto, @PathVariable agentId: String
    ): ResponseEntity<ContactDto> {
        return emergencyContactUsecase.updateEmergencyContact(id, contactDto)
    }

}