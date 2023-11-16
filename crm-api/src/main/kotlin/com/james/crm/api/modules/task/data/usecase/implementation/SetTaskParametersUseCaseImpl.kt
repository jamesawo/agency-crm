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
import com.james.crm.api.modules.task.data.dto.SetTaskParametersInput
import com.james.crm.api.modules.task.data.dto.TaskDto
import com.james.crm.api.modules.task.data.repository.TaskDataRepository
import com.james.crm.api.modules.task.data.usecase.contract.ISetTaskParametersUsecase
import org.springframework.data.crossstore.ChangeSetPersister
import org.springframework.http.HttpStatus.*
import org.springframework.http.ResponseEntity

@Usecase
class SetTaskParametersUseCaseImpl(
    private val taskRepository: TaskDataRepository
) : ISetTaskParametersUsecase {

    override fun execute(input: SetTaskParametersInput): ResponseEntity<ApiResponse<TaskDto>> {
        return try {
            val task = taskRepository.findById(input.taskId).orElseThrow { Error("Task not found") }

            // Set task parameters
            task.startDate = input.startDate
            task.endDate = input.endDate
            task.budget = input.budget
            task.commissionType = input.commissionType
            task.commissionRate = input.commissionRate

            val updatedTask = taskRepository.save(task)
            successResponse(OK, TaskDto.Companion.toRequest(updatedTask))
        } catch (ex: ChangeSetPersister.NotFoundException) {
            errorResponse(NOT_FOUND, CatchableError(NOT_FOUND, listOf(ex.localizedMessage), ex))
        } catch (ex: Exception) {
            errorResponse(INTERNAL_SERVER_ERROR, CatchableError(INTERNAL_SERVER_ERROR, ex))
        }
    }
}