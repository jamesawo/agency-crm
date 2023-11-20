/*
 * @Author: james.aworo
 * @Date: 11/8/23
 *
 * @Project: agent-crm
 */

package com.james.crm.api.modules.people.data.usecase.contract.agent

import com.james.crm.api.core.common.ApiResponse
import com.james.crm.api.modules.task.data.dto.TaskDto
import org.springframework.http.ResponseEntity

interface IAgentTaskUsecase {
    fun getTasks(agentId: String): ResponseEntity<ApiResponse<List<TaskDto>>>
    fun assignTask(input: Pair<String, String>): ResponseEntity<ApiResponse<Boolean>>
}