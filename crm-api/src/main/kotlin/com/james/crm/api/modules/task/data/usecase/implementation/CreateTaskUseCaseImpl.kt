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
import com.james.crm.api.modules.task.data.dto.TaskDto
import com.james.crm.api.modules.task.data.repository.TaskDataRepository
import com.james.crm.api.modules.task.data.usecase.contract.ICreateTaskUsecase
import org.springframework.http.HttpStatus.CREATED
import org.springframework.http.HttpStatus.INTERNAL_SERVER_ERROR
import org.springframework.http.ResponseEntity

@Usecase
class CreateTaskUseCaseImpl(
    private val taskRepository: TaskDataRepository,
) : ICreateTaskUsecase {

    override fun execute(input: TaskDto): ResponseEntity<ApiResponse<TaskDto>> {
        return try {
            val savedTask = taskRepository.save(TaskDto.toEntity(input))
            successResponse(CREATED, TaskDto.toRequest(savedTask))
        } catch (ex: Exception) {
            errorResponse(INTERNAL_SERVER_ERROR, CatchableError(INTERNAL_SERVER_ERROR, listOf(ex.localizedMessage), ex))
        }
    }
}
