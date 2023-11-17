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
import com.james.crm.api.modules.task.data.dto.SetTaskParametersInput
import com.james.crm.api.modules.task.data.dto.TaskDto
import com.james.crm.api.modules.task.data.repository.TaskDataRepository
import com.james.crm.api.modules.task.data.usecase.contract.ISetTaskParametersUsecase
import org.springframework.http.HttpStatus.*
import org.springframework.http.ResponseEntity

@Usecase
class SetTaskParametersUseCaseImpl(
    private val taskRepository: TaskDataRepository
) : ISetTaskParametersUsecase {

    override fun execute(input: SetTaskParametersInput): ResponseEntity<ApiResponse<Boolean>> {
        return try {
            taskRepository.findById(input.taskId).map { task ->
                taskRepository.save(TaskDto.setTaskParameter(task, input))
                successResponse(OK, true)
            }.orElse(errorResponse(NOT_FOUND, notFoundMessageAsList("task")))
        } catch (ex: Exception) {
            errorResponse(INTERNAL_SERVER_ERROR, CatchableError(INTERNAL_SERVER_ERROR, ex))
        }
    }
}