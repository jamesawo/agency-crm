/*
 * @Author: james.aworo
 * @Date: 11/7/23
 *
 * @Project: agent-crm
 */

package com.james.crm.api.modules.people.data.usecase.implementation

import com.james.crm.api.core.annotation.Usecase
import com.james.crm.api.modules.people.data.dto.AgentDto
import com.james.crm.api.modules.people.data.usecase.contract.agent.IAgentUsecase
import com.james.crm.api.modules.people.domain.repository.AgentDataRepository
import org.springframework.http.ResponseEntity

@Usecase
class AgentUsecaseImpl(
    private val repository: AgentDataRepository
) : IAgentUsecase {
    override fun create(agent: AgentDto): ResponseEntity<AgentDto> {
        val saved = repository.save(AgentDto.toEntity(agent))
        return ResponseEntity.ok().body(AgentDto.toTrimmedRequest(saved))
    }

    override fun find(agentId: String): ResponseEntity<AgentDto?> {
        TODO("Not yet implemented")
    }

    override fun find(): ResponseEntity<List<AgentDto>> {
        TODO("Not yet implemented")
    }

    override fun findByEmail(email: String): ResponseEntity<AgentDto?> {
        TODO("Not yet implemented")
    }

    override fun update(agent: AgentDto): ResponseEntity<AgentDto> {

        TODO("Not yet implemented")
    }

}

