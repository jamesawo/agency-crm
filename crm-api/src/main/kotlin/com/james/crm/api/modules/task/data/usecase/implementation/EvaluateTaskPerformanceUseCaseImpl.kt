/*
 * @Author: james.aworo
 * @Date: 11/16/23
 *
 * @Project: agent-crm
 */

package com.james.crm.api.modules.task.data.usecase.implementation

import com.james.crm.api.core.annotation.Usecase
import com.james.crm.api.core.common.ApiResponse
import com.james.crm.api.core.common.CatchableError
import com.james.crm.api.core.util.Util.Companion.errorResponse
import com.james.crm.api.core.util.Util.Companion.notFoundMessageAsList
import com.james.crm.api.core.util.Util.Companion.successResponse
import com.james.crm.api.modules.task.data.dto.TaskPerformanceDto
import com.james.crm.api.modules.task.data.repository.TaskDataRepository
import com.james.crm.api.modules.task.data.usecase.contract.IEvaluateTaskPerformanceUsecase
import com.james.crm.api.modules.task.domain.Task
import com.james.crm.api.modules.task.domain.enums.TaskStatus
import org.springframework.http.HttpStatus.*
import org.springframework.http.ResponseEntity

@Usecase
class EvaluateTaskPerformanceUseCaseImpl(
    private val taskRepository: TaskDataRepository
) : IEvaluateTaskPerformanceUsecase {

    override fun execute(input: String): ResponseEntity<ApiResponse<TaskPerformanceDto>> {
        return try {
            taskRepository.findById(input)
                .map { task -> successResponse(OK, calculateCompletionPercentage(task)) }
                .orElse(errorResponse(NOT_FOUND, notFoundMessageAsList("task")))
        } catch (ex: Exception) {
            errorResponse(INTERNAL_SERVER_ERROR, CatchableError(INTERNAL_SERVER_ERROR, listOf(ex.localizedMessage), ex))
        }
    }

    private fun calculateCompletionPercentage(task: Task): TaskPerformanceDto {
        /*
        todo
         Implement completion percentage calculation logic based on task details
         For example, you can use task status and timelines
         Return the calculated completion percentage
         */
        return TaskPerformanceDto(
            taskId = task.id ?: "",
            taskTitle = task.title,
            status = task.status ?: TaskStatus.OPEN,
            startDate = task.startDate,
            endDate = task.endDate,
            completionPercentage = 0.0,
            completionAmount = 0.00,
            comments = listOf("Task performance evaluation comments")
        )
    }
}
