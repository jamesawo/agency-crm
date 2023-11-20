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
import com.james.crm.api.modules.task.data.dto.TaskCommissionDto
import com.james.crm.api.modules.task.data.repository.TaskDataRepository
import com.james.crm.api.modules.task.data.usecase.contract.ITrackTaskCommissionUsecase
import com.james.crm.api.modules.task.domain.Task
import org.springframework.http.HttpStatus.*
import org.springframework.http.ResponseEntity

@Usecase
class TrackTaskCommissionUseCaseImpl(
    private val taskRepository: TaskDataRepository
) : ITrackTaskCommissionUsecase {

    override fun execute(input: String): ResponseEntity<ApiResponse<TaskCommissionDto>> {
        return try {
            taskRepository.findById(input)
                .map { successResponse(OK, calculateCommission(it)) }
                .orElse(errorResponse(NOT_FOUND, notFoundMessageAsList("task")))
        } catch (ex: Exception) {
            errorResponse(INTERNAL_SERVER_ERROR, CatchableError(INTERNAL_SERVER_ERROR, listOf(ex.localizedMessage), ex))
        }
    }

    private fun calculateCommission(task: Task): TaskCommissionDto {
        /*
        todo
         Implement commission calculation logic based on task details
         For example, you can use task.commissionType and task.commissionRate
         Return the calculated commission amount
         */
        return TaskCommissionDto(
            taskId = task.id,
            commission = task.commissionRate,
            commissionType = task.commissionType
        )
    }
}
