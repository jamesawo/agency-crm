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
@RequestMapping("${Route.BASE}/agents/{agentId}/manager")
class AgentManagerEndpoint(
    private val managerUsecase: IAgentManagerUsecase
) {

    @GetMapping("/{id}/manager")
    fun getManager(@PathVariable id: String, @PathVariable agentId: String): ResponseEntity<ManagerDto> =
        managerUsecase.getManager(id)

    @PutMapping("/{id}/manager")
    fun updateManager(
        @PathVariable id: String,
        @RequestBody managerDto: ManagerDto,
        @PathVariable agentId: String
    ): ResponseEntity<ManagerDto> =
        managerUsecase.updateManager(id, managerDto)
}