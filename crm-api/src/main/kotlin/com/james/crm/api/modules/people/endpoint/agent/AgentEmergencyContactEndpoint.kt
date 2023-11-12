/*
 * @Author: james.aworo
 * @Date: 11/8/23
 *
 * @Project: agent-crm
 */

package com.james.crm.api.modules.people.endpoint.agent

import com.james.crm.api.core.common.ApiResponse
import com.james.crm.api.core.constant.Route
import com.james.crm.api.modules.people.data.dto.EmergencyContactDto
import com.james.crm.api.modules.people.data.usecase.contract.agent.IAgentEmergencyContactUsecase
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("${Route.API_VERSION}/agents/{agentId}/emergency-contact")
class AgentEmergencyContactEndpoint(
    private val emergencyContactUsecase: IAgentEmergencyContactUsecase
) {

    @GetMapping()
    fun getEmergencyContact(@PathVariable agentId: String): ResponseEntity<ApiResponse<EmergencyContactDto>> {
        return emergencyContactUsecase.getEmergencyContact(agentId)
    }

    @PutMapping()
    fun updateEmergencyContact(
        @RequestBody contactDto: EmergencyContactDto, @PathVariable agentId: String
    ): ResponseEntity<ApiResponse<EmergencyContactDto>> {
        return emergencyContactUsecase.updateEmergencyContact(agentId, contactDto)
    }

}