/*
 * @Author: james.aworo
 * @Date: 11/8/23
 *
 * @Project: agent-crm
 */

package com.james.crm.api.modules.people.data.usecase.implementation.agent

import com.james.crm.api.core.annotation.Usecase
import com.james.crm.api.core.common.ApiResponse
import com.james.crm.api.modules.people.data.usecase.contract.agent.IAgentTaskUsecase
import com.james.crm.api.modules.task.data.dto.TaskDto
import org.springframework.http.ResponseEntity

@Usecase
class AgentTaskUsecase : IAgentTaskUsecase {
    override fun getTasks(agentId: String): ResponseEntity<ApiResponse<List<TaskDto>>> {
        TODO()
    }

    override fun assignTask(input: Pair<String, String>): ResponseEntity<ApiResponse<Boolean>> {
        TODO()
    }
}