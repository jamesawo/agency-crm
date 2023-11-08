/*
 * @Author: james.aworo
 * @Date: 11/8/23
 *
 * @Project: agent-crm
 */

package com.james.crm.api.modules.people.data.usecase.implementation.agent

import com.james.crm.api.core.annotation.Usecase
import com.james.crm.api.modules.people.data.dto.ManagerDto
import com.james.crm.api.modules.people.data.usecase.contract.agent.IAgentManagerUsecase
import org.springframework.http.ResponseEntity

@Usecase
class AgentManagerUsecase : IAgentManagerUsecase {
    override fun getManager(agentId: String): ResponseEntity<ManagerDto> {
        TODO()
    }

    override fun updateManager(agentId: String, managerDto: ManagerDto): ResponseEntity<ManagerDto> {
        TODO()
    }
}