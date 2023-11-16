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
import com.james.crm.api.modules.task.data.repository.TaskDataRepository
import com.james.crm.api.modules.task.data.usecase.contract.IMonitorTaskBudgetUsecase
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException
import org.springframework.http.HttpStatus.*
import org.springframework.http.ResponseEntity

@Usecase
class MonitorTaskBudgetUseCaseImpl(
    private val taskRepository: TaskDataRepository
) : IMonitorTaskBudgetUsecase {

    override fun execute(input: String): ResponseEntity<ApiResponse<Double>> {
        return try {
            val task = taskRepository.findById(input).orElseThrow { Error("Task not found") }

            successResponse(OK, task.budget)
        } catch (ex: NotFoundException) {
            errorResponse(NOT_FOUND, CatchableError(NOT_FOUND, listOf(ex.localizedMessage), ex))
        } catch (ex: Exception) {
            errorResponse(INTERNAL_SERVER_ERROR, CatchableError(INTERNAL_SERVER_ERROR, listOf(ex.localizedMessage), ex))
        }
    }
}
