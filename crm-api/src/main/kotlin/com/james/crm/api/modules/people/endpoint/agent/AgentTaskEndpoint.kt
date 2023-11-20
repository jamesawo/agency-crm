/*
 * @Author: james.aworo
 * @Date: 11/8/23
 *
 * @Project: agent-crm
 */

package com.james.crm.api.modules.people.endpoint.agent

import com.james.crm.api.core.common.ApiResponse
import com.james.crm.api.core.constant.Route
import com.james.crm.api.modules.people.data.usecase.contract.agent.IAgentTaskUsecase
import com.james.crm.api.modules.task.data.dto.TaskDto
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("${Route.API_VERSION}/agents/{agentId}/task")
class AgentTaskEndpoint(
    private val taskUsecase: IAgentTaskUsecase
) {
    @GetMapping("/retrieve")
    fun getTasks(
        @PathVariable agentId: String
    ): ResponseEntity<ApiResponse<List<TaskDto>>> {
        // WIP
        return taskUsecase.getTasks(agentId)
    }

    @PostMapping("/assign/{taskId}")
    fun assignTask(
        @PathVariable agentId: String,
        @PathVariable taskId: String
    ): ResponseEntity<ApiResponse<Boolean>> {
        // WIP
        return taskUsecase.assignTask(Pair(agentId, taskId))
    }

}