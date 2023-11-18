/*
 * @Author: james.aworo
 * @Date: 11/8/23
 *
 * @Project: agent-crm
 */

package com.james.crm.api.modules.people.data.usecase.implementation.agent

import com.james.crm.api.core.annotation.Usecase
import com.james.crm.api.core.common.ApiResponse
import com.james.crm.api.core.util.Util.Companion.errorResponse
import com.james.crm.api.core.util.Util.Companion.notFoundMessageAsList
import com.james.crm.api.core.util.Util.Companion.successResponse
import com.james.crm.api.modules.people.data.dto.manager.ManagerDto
import com.james.crm.api.modules.people.data.usecase.contract.agent.IAgentManagerUsecase
import com.james.crm.api.modules.people.data.usecase.contract.manager.IManagerUsecase
import com.james.crm.api.modules.people.domain.repository.AgentDataRepository
import org.springframework.http.HttpStatus.NOT_FOUND
import org.springframework.http.HttpStatus.OK
import org.springframework.http.ResponseEntity

@Usecase
class AgentManagerUsecase(
    private val agentRepo: AgentDataRepository,
    private val managerUsecase: IManagerUsecase
) : IAgentManagerUsecase {

    override fun getManager(agentId: String): ResponseEntity<ApiResponse<ManagerDto?>> {
        return agentRepo.findById(agentId).map {
            val data = it.manager?.let { manager -> ManagerDto.toTrimRequest(manager) }
            successResponse(OK, data)
        }.orElse(errorResponse(NOT_FOUND, notFoundMessageAsList("agent")))
    }

    override fun updateManager(agentId: String, managerId: String): ResponseEntity<ApiResponse<Boolean>> {
        return managerUsecase.findById(managerId).flatMap { manager ->
            agentRepo.findById(agentId).map { agent ->
                agent.manager = manager
                agentRepo.save(agent)
                successResponse(OK, true)
            }
        }.orElse(errorResponse(NOT_FOUND, notFoundMessageAsList("manager")))
    }

}