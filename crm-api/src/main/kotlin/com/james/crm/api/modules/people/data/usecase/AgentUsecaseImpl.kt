/*
 * @Author: james.aworo
 * @Date: 11/7/23
 *
 * @Project: agent-crm
 */

package com.james.crm.api.modules.people.data.usecase

import com.james.crm.api.modules.people.domain.model.Agent
import com.james.crm.api.modules.people.domain.usecase.IAgentUsecase
import org.springframework.stereotype.Service

@Service
class AgentUsecaseImpl : IAgentUsecase {
    override fun create(agent: Agent): Agent {
        TODO("Not yet implemented")
    }

    override fun find(agentId: String): Agent? {
        TODO("Not yet implemented")
    }

    override fun find(): List<Agent> {
        TODO("Not yet implemented")
    }

    override fun findByEmail(email: String): Agent? {
        TODO("Not yet implemented")
    }

    override fun update(agent: Agent): Agent {
        TODO("Not yet implemented")
    }


}