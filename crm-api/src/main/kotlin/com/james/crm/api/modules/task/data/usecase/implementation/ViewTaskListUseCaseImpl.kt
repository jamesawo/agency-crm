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
import com.james.crm.api.modules.task.data.usecase.contract.IViewTaskListUsecase
import org.springframework.http.HttpStatus.INTERNAL_SERVER_ERROR
import org.springframework.http.HttpStatus.OK
import org.springframework.http.ResponseEntity

@Usecase
class ViewTaskListUseCaseImpl(
    private val taskRepository: TaskDataRepository
) : IViewTaskListUsecase {

    override fun execute(input: Unit): ResponseEntity<ApiResponse<List<TaskDto>>> {
        return try {
            val tasks = taskRepository.findAll().map { TaskDto.toRequest(it) }
            successResponse(OK, tasks)
        } catch (ex: Exception) {
            errorResponse(INTERNAL_SERVER_ERROR, CatchableError(INTERNAL_SERVER_ERROR, listOf(ex.localizedMessage), ex))
        }
    }
}
