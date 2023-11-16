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
import com.james.crm.api.modules.task.data.dto.SetTaskStatusInput
import com.james.crm.api.modules.task.data.dto.TaskDto
import com.james.crm.api.modules.task.data.repository.TaskDataRepository
import com.james.crm.api.modules.task.data.usecase.contract.ISetTaskStatusUsecase
import org.springframework.data.crossstore.ChangeSetPersister
import org.springframework.http.HttpStatus.*
import org.springframework.http.ResponseEntity

@Usecase
class SetTaskStatusUseCaseImpl(
    private val taskRepository: TaskDataRepository
) : ISetTaskStatusUsecase {

    override fun execute(input: SetTaskStatusInput): ResponseEntity<ApiResponse<TaskDto>> {
        return try {
            val task = taskRepository.findById(input.taskId).orElseThrow { Error("Task not found") }

            // Set task status
            task.status = input.status

            val updatedTask = taskRepository.save(task)
            successResponse(OK, TaskDto.Companion.toRequest(updatedTask))
        } catch (ex: ChangeSetPersister.NotFoundException) {
            errorResponse(NOT_FOUND, CatchableError(NOT_FOUND, listOf(ex.localizedMessage), ex))
        } catch (ex: Exception) {
            errorResponse(INTERNAL_SERVER_ERROR, CatchableError(INTERNAL_SERVER_ERROR, listOf(ex.localizedMessage), ex))
        }
    }
}

