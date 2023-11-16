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
import com.james.crm.api.modules.pipeline.data.dto.PipelineDto
import com.james.crm.api.modules.task.data.repository.TaskDataRepository
import com.james.crm.api.modules.task.data.usecase.contract.IViewAssociatedPipelinesUsecase
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException
import org.springframework.http.HttpStatus.*
import org.springframework.http.ResponseEntity

@Usecase
class ViewAssociatedPipelinesUseCaseImpl(
    private val taskRepository: TaskDataRepository
) : IViewAssociatedPipelinesUsecase {

    override fun execute(input: String): ResponseEntity<ApiResponse<List<PipelineDto>>> {
        return try {
            val task = taskRepository.findById(input).orElseThrow { Error("Task not found") }

            // Extract associated pipelines
            val pipelines = task.pipeline?.let { listOf(PipelineDto.Companion.toRequest(it)) } ?: emptyList()

            successResponse(OK, pipelines)
        } catch (ex: NotFoundException) {
            errorResponse(NOT_FOUND, CatchableError(NOT_FOUND, listOf(ex.localizedMessage), ex))
        } catch (ex: Exception) {
            errorResponse(INTERNAL_SERVER_ERROR, CatchableError(INTERNAL_SERVER_ERROR, listOf(ex.localizedMessage), ex))
        }
    }
}


