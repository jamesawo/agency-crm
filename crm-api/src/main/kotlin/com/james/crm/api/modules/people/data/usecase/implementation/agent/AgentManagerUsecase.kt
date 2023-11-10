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
import com.james.crm.api.modules.people.data.usecase.contract.manager.IManagerUsecase
import com.james.crm.api.modules.people.domain.repository.AgentDataRepository
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity

@Usecase
class AgentManagerUsecase(
    private val repository: AgentDataRepository,
    private val managerUsecase: IManagerUsecase
) : IAgentManagerUsecase {
    
    override fun getManager(agentId: String): ResponseEntity<ManagerDto> {
        return repository.findById(agentId).map {
            ResponseEntity.ok().body(it.manager?.let { it1 -> ManagerDto.toRequest(it1) })
        }.orElse(ResponseEntity.notFound().build())
    }

    override fun updateManager(agentId: String, managerId: String): ResponseEntity<Boolean> {
        val optManager = managerUsecase.findById(managerId)
        val optAgent = repository.findById(agentId)

        if (optManager.isPresent && optAgent.isPresent) {
            val agent = optAgent.get()
            agent.manager = optManager.get()
            repository.save(agent)
            return ResponseEntity(true, HttpStatus.OK)
        }
        return ResponseEntity(false, HttpStatus.NOT_FOUND)
    }

}