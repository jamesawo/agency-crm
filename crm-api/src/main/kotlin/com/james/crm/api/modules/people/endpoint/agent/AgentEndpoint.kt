/*
 * @Author: james.aworo
 * @Date: 11/1/23
 *
 * @Project: agent-crm
 */

package com.james.crm.api.modules.people.endpoint.agent

import com.james.crm.api.core.common.ApiResponse
import com.james.crm.api.core.constant.Route.Companion.API_VERSION
import com.james.crm.api.modules.people.data.dto.AgentDto
import com.james.crm.api.modules.people.data.usecase.contract.agent.IAgentUsecase
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("$API_VERSION/agents/")
class AgentEndpoint(
    private val usecase: IAgentUsecase
) {
    @PostMapping()
    fun create(@RequestBody agentDto: AgentDto): ResponseEntity<ApiResponse<AgentDto>> {
        return usecase.create(agentDto)
    }

    @DeleteMapping("{id}")
    fun delete(@PathVariable id: String): ResponseEntity<ApiResponse<Boolean>> {
        return usecase.remove(id)
    }
}