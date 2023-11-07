/*
 * @Author: james.aworo
 * @Date: 11/3/23
 *
 * @Project: agent-crm
 */

package com.james.crm.api.modules.people.domain.usecase

import com.james.crm.api.modules.people.domain.model.Agent

interface IAgentUsecase{
    fun create(agent: Agent): Agent

    fun find(agentId: String): Agent?

    fun findByEmail(email: String): Agent?

    fun update(agent: Agent): Agent

    fun find(): List<Agent>


}
