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
import com.james.crm.api.modules.task.data.dto.TaskBudgetDto
import com.james.crm.api.modules.task.data.repository.TaskDataRepository
import com.james.crm.api.modules.task.data.usecase.contract.IMonitorTaskBudgetUsecase
import org.springframework.http.HttpStatus.INTERNAL_SERVER_ERROR
import org.springframework.http.HttpStatus.OK
import org.springframework.http.ResponseEntity

@Usecase
class MonitorTaskBudgetUseCaseImpl(
    private val taskRepository: TaskDataRepository
) : IMonitorTaskBudgetUsecase {

    override fun execute(input: String): ResponseEntity<ApiResponse<TaskBudgetDto>> {
        return try {
            taskRepository.findById(input)
                .map { successResponse(OK, TaskBudgetDto(it.id, it.budget)) }
                .orElse(errorResponse(INTERNAL_SERVER_ERROR, notFoundMessageAsList("task")))
        } catch (ex: Exception) {
            errorResponse(INTERNAL_SERVER_ERROR, CatchableError(INTERNAL_SERVER_ERROR, listOf(ex.localizedMessage), ex))
        }
    }
}
