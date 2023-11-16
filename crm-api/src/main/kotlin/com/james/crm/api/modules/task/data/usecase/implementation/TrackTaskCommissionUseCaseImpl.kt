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
import com.james.crm.api.modules.task.data.usecase.contract.ITrackTaskCommissionUsecase
import com.james.crm.api.modules.task.domain.Task
import org.springframework.data.crossstore.ChangeSetPersister
import org.springframework.http.HttpStatus.*
import org.springframework.http.ResponseEntity

@Usecase
class TrackTaskCommissionUseCaseImpl(
    private val taskRepository: TaskDataRepository
) : ITrackTaskCommissionUsecase {

    override fun execute(input: String): ResponseEntity<ApiResponse<Double>> {
        return try {
            val task = taskRepository.findById(input).orElseThrow { Error("Task not found") }

            successResponse(OK, calculateCommission(task))
        } catch (ex: ChangeSetPersister.NotFoundException) {
            errorResponse(NOT_FOUND, CatchableError(NOT_FOUND, listOf(ex.localizedMessage), ex))
        } catch (ex: Exception) {
            errorResponse(INTERNAL_SERVER_ERROR, CatchableError(INTERNAL_SERVER_ERROR, listOf(ex.localizedMessage), ex))
        }
    }

    private fun calculateCommission(task: Task): Double {
        // Implement commission calculation logic based on task details
        // For example, you can use task.commissionType and task.commissionRate
        // Return the calculated commission amount
        return 0.0
    }
}
