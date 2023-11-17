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
import com.james.crm.api.modules.pipeline.data.dto.PipelineDto
import com.james.crm.api.modules.task.data.repository.TaskDataRepository
import com.james.crm.api.modules.task.data.usecase.contract.IViewAssociatedPipelinesUsecase
import org.springframework.http.HttpStatus.INTERNAL_SERVER_ERROR
import org.springframework.http.HttpStatus.OK
import org.springframework.http.ResponseEntity

@Usecase
class ViewAssociatedPipelinesUseCaseImpl(
    private val taskRepository: TaskDataRepository
) : IViewAssociatedPipelinesUsecase {

    override fun execute(input: String): ResponseEntity<ApiResponse<List<PipelineDto>>> {
        return try {
            taskRepository.findById(input).map { task ->
                //todo revisit task and pipeline relationship, (one task can have multiple pipelines)
                val pipelines = task.pipeline?.let { listOf(PipelineDto.toRequest(it)) } ?: emptyList()
                successResponse(OK, pipelines)
            }.orElse(errorResponse(INTERNAL_SERVER_ERROR, notFoundMessageAsList("task")))
        } catch (ex: Exception) {
            errorResponse(INTERNAL_SERVER_ERROR, CatchableError(INTERNAL_SERVER_ERROR, ex))
        }
    }
}


