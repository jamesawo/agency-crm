/*
 * @Author: james.aworo
 * @Date: 11/3/23
 *
 * @Project: agent-crm
 */

package com.james.crm.api.modules.people.data.usecase.interfaces

import com.james.crm.api.modules.people.data.dto.AgentDto

interface IAgentUsecase{
    fun create(agent: AgentDto): AgentDto

    fun find(agentId: String): AgentDto?

    fun findByEmail(email: String): AgentDto?

    fun update(agent: AgentDto): AgentDto

    fun find(): List<AgentDto>


}
