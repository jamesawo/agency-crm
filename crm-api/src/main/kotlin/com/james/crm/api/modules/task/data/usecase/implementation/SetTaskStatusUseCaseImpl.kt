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
import com.james.crm.api.modules.task.data.dto.SetTaskStatusInput
import com.james.crm.api.modules.task.data.repository.TaskDataRepository
import com.james.crm.api.modules.task.data.usecase.contract.ISetTaskStatusUsecase
import org.springframework.http.HttpStatus.*
import org.springframework.http.ResponseEntity

@Usecase
class SetTaskStatusUseCaseImpl(
    private val taskRepository: TaskDataRepository
) : ISetTaskStatusUsecase {

    override fun execute(input: SetTaskStatusInput): ResponseEntity<ApiResponse<Boolean>> {
        return try {
            taskRepository.findById(input.taskId).map { task ->
                task.status = input.status
                taskRepository.save(task)
                successResponse(OK, true)
            }.orElse(
                errorResponse(NOT_FOUND, notFoundMessageAsList("task"))
            )
        } catch (ex: Exception) {
            errorResponse(INTERNAL_SERVER_ERROR, CatchableError(INTERNAL_SERVER_ERROR, ex))
        }
    }
}

