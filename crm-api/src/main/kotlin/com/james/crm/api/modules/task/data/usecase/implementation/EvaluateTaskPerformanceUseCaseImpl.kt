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
import com.james.crm.api.core.util.Util.Companion.successResponse
import com.james.crm.api.modules.task.data.dto.TaskPerformanceDto
import com.james.crm.api.modules.task.data.repository.TaskDataRepository
import com.james.crm.api.modules.task.data.usecase.contract.IEvaluateTaskPerformanceUsecase
import com.james.crm.api.modules.task.domain.Task
import com.james.crm.api.modules.task.domain.enums.TaskStatus
import org.springframework.data.crossstore.ChangeSetPersister
import org.springframework.http.HttpStatus.*
import org.springframework.http.ResponseEntity

@Usecase
class EvaluateTaskPerformanceUseCaseImpl(
    private val taskRepository: TaskDataRepository
) : IEvaluateTaskPerformanceUsecase {

    override fun execute(input: String): ResponseEntity<ApiResponse<TaskPerformanceDto>> {
        return try {
            val task = taskRepository.findById(input).orElseThrow { Error("Task not found") }

            val taskPerformance = TaskPerformanceDto(
                taskId = task.id ?: "",
                taskTitle = task.title,
                status = task.status ?: TaskStatus.OPEN,
                startDate = task.startDate,
                endDate = task.endDate,
                completionPercentage = calculateCompletionPercentage(task),
                comments = listOf("Task performance evaluation comments")
            )

            successResponse(OK, taskPerformance)
        } catch (ex: ChangeSetPersister.NotFoundException) {
            errorResponse(NOT_FOUND, CatchableError(NOT_FOUND, listOf(ex.localizedMessage), ex))
        } catch (ex: Exception) {
            errorResponse(INTERNAL_SERVER_ERROR, CatchableError(INTERNAL_SERVER_ERROR, listOf(ex.localizedMessage), ex))
        }
    }

    private fun calculateCompletionPercentage(task: Task): Double {
        // Implement completion percentage calculation logic based on task details
        // For example, you can use task status and timelines
        // Return the calculated completion percentage
        return 0.0
    }
}
