/*
 * @Author: james.aworo
 * @Date: 11/7/23
 *
 * @Project: agent-crm
 */

package com.james.crm.api.modules.people.data.usecase

import com.james.crm.api.modules.people.data.dto.AgentDto
import com.james.crm.api.modules.people.domain.repository.AgentDataRepository
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Service

@Service
class AgentUsecaseImpl(private val repository: AgentDataRepository)  {

    fun create(agentDto: AgentDto): ResponseEntity<AgentDto>{
        val agent = agentDto.toEntity()
        println(agent.contact.email)
        return ResponseEntity.ok(agentDto)
    }
}

