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
import com.james.crm.api.modules.pipeline.data.repository.PipelineDataRepository
import com.james.crm.api.modules.task.data.repository.TaskDataRepository
import com.james.crm.api.modules.task.data.usecase.contract.IAssignPipelineToTaskUsecase
import org.springframework.http.HttpStatus.*
import org.springframework.http.ResponseEntity

@Usecase
class AssignPipelineToTaskUseCaseImpl(
    private val taskRepository: TaskDataRepository,
    private val pipelineRepository: PipelineDataRepository
) : IAssignPipelineToTaskUsecase {

    override fun execute(input: Pair<String, String>): ResponseEntity<ApiResponse<Boolean>> {
        return try {
            taskRepository.findById(input.first).flatMap { task ->
                pipelineRepository.findById(input.second).map { pipeline ->
                    task.pipeline = pipeline
                    taskRepository.save(task)
                    successResponse(OK, true)
                }
            }.orElse(errorResponse(NOT_FOUND, notFoundMessageAsList("task / pipeline")))
        } catch (ex: Exception) {
            errorResponse(INTERNAL_SERVER_ERROR, CatchableError(INTERNAL_SERVER_ERROR, ex))
        }
    }
}

