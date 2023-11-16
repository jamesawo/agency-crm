package com.james.crm.api.modules.people.endpoint.agent

import com.james.crm.api.core.common.ApiResponse
import com.james.crm.api.core.constant.Route.Companion.API_VERSION
import com.james.crm.api.modules.people.data.dto.ContactDto
import com.james.crm.api.modules.people.data.usecase.contract.agent.IAgentContactUsecase
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("$API_VERSION/agents/{agentId}/contact")
class AgentContactEndpoint(
    private val contactUsecase: IAgentContactUsecase
) {
    @GetMapping
    fun getContact(
        @PathVariable agentId: String
    ): ResponseEntity<ApiResponse<ContactDto>> {
        return contactUsecase.getContact(agentId)
    }

    @PutMapping()
    fun updateContact(
        @RequestBody contactDto: ContactDto,
        @PathVariable agentId: String
    ): ResponseEntity<ApiResponse<Boolean>> {
        return contactUsecase.updateContact(agentId, contactDto)
    }

}