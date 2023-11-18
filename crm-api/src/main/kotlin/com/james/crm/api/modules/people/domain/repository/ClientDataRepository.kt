/*
 * @Author: james.aworo
 * @Date: 11/7/23
 *
 * @Project: agent-crm
 */

package com.james.crm.api.modules.people.domain.repository

import com.james.crm.api.modules.people.domain.model.Agent
import com.james.crm.api.modules.people.domain.model.Client
import org.springframework.data.jpa.repository.JpaRepository

interface ClientDataRepository : JpaRepository<Client, String> {
    fun findAllByAgent(agent: Agent): List<Client>
}
