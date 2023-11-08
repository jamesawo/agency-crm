/*
 * @Author: james.aworo
 * @Date: 11/8/23
 *
 * @Project: agent-crm
 */

package com.james.crm.api.modules.people.data.usecase.implementation.agent

import com.james.crm.api.core.annotation.Usecase
import com.james.crm.api.modules.people.data.dto.TaskDto
import com.james.crm.api.modules.people.data.usecase.contract.agent.IAgentTaskUsecase
import org.springframework.http.ResponseEntity

@Usecase
class AgentTaskUsecase : IAgentTaskUsecase {
    override fun getTasks(agentId: String): ResponseEntity<List<TaskDto>> {
        TODO()
    }

    override fun assignTask(agentId: String, taskDto: TaskDto): ResponseEntity<TaskDto> {
        TODO()
    }
}