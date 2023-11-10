/*
 * @Author: james.aworo
 * @Date: 11/3/23
 *
 * @Project: agent-crm
 */

package com.james.crm.api.modules.people.data.usecase.contract.agent

import com.james.crm.api.modules.people.data.dto.AgentDto
import org.springframework.http.ResponseEntity

interface IAgentUsecase {
    fun create(agent: AgentDto): ResponseEntity<AgentDto>

    fun find(agentId: String): ResponseEntity<AgentDto?>

    fun findByEmail(email: String): ResponseEntity<AgentDto?>

    fun update(agent: AgentDto): ResponseEntity<AgentDto>

    fun find(): ResponseEntity<List<AgentDto>>

    fun remove(id: String): ResponseEntity<Boolean>

}
