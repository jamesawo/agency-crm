/*
 * @Author: james.aworo
 * @Date: 11/7/23
 *
 * @Project: agent-crm
 */

package com.james.crm.api.modules.people.domain.repository

import com.james.crm.api.modules.people.domain.model.Agent
import org.springframework.data.jpa.repository.JpaRepository

interface AgentDataRepository : JpaRepository<Agent, String>