/*
 * @Author: james.aworo
 * @Date: 11/8/23
 *
 * @Project: agent-crm
 */

package com.james.crm.api.modules.people.endpoint.agent

import com.james.crm.api.core.common.ApiResponse
import com.james.crm.api.core.constant.Route
import com.james.crm.api.modules.people.data.dto.TaskDto
import com.james.crm.api.modules.people.data.usecase.contract.agent.IAgentTaskUsecase
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("${Route.API_VERSION}/agents/{agentId}/task")
class AgentTaskEndpoint(
    private val taskUsecase: IAgentTaskUsecase
) {
    @GetMapping("/{id}/tasks")
    fun getTasks(
        @PathVariable id: String, @PathVariable agentId: String
    ): ResponseEntity<ApiResponse<List<TaskDto>>> {
        return taskUsecase.getTasks(id)
    }

    @PostMapping("/{id}/tasks")
    fun assignTask(
        @PathVariable id: String,
        @RequestBody taskDto: TaskDto,
        @PathVariable agentId: String
    ): ResponseEntity<ApiResponse<TaskDto>> {
        return taskUsecase.assignTask(id, taskDto)
    }

}