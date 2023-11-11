/*
 * @Author: james.aworo
 * @Date: 11/8/23
 *
 * @Project: agent-crm
 */

package com.james.crm.api.modules.people.endpoint.agent

import com.james.crm.api.core.constant.Route
import com.james.crm.api.modules.people.data.dto.ManagerDto
import com.james.crm.api.modules.people.data.usecase.contract.agent.IAgentManagerUsecase
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*


@RestController
@RequestMapping("${Route.API_VERSION}/agents/{agentId}/manager")
class AgentManagerEndpoint(
    private val managerUsecase: IAgentManagerUsecase
) {

    @GetMapping
    fun getManager(@PathVariable agentId: String): ResponseEntity<ManagerDto> =
        managerUsecase.getManager(agentId)

    @PatchMapping("{managerId}")
    fun assignManager(@PathVariable agentId: String, @PathVariable managerId: String): ResponseEntity<Boolean> {
        return managerUsecase.updateManager(agentId, managerId)
    }
}