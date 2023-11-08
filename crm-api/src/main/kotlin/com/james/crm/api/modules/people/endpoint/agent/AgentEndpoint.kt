/*
 * @Author: james.aworo
 * @Date: 11/1/23
 *
 * @Project: agent-crm
 */

package com.james.crm.api.modules.people.endpoint.agent

import com.james.crm.api.core.constant.Route
import com.james.crm.api.modules.people.data.dto.AgentDto
import com.james.crm.api.modules.people.data.usecase.contract.agent.IAgentUsecase
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("${Route.BASE}/agents/")
class AgentEndpoint(
    private val usecase: IAgentUsecase
) {
    @PostMapping()
    fun create(@RequestBody agentDto: AgentDto): ResponseEntity<AgentDto> {
        return usecase.create(agentDto)
    }

    @PutMapping
    fun update(@RequestBody agentDto: AgentDto): ResponseEntity<AgentDto> {
        return usecase.update(agentDto)
    }
    
}