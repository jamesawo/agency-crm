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
import com.james.crm.api.modules.pipeline.data.repository.PipelineDataRepository
import com.james.crm.api.modules.task.data.dto.AssignPipelineToTaskInput
import com.james.crm.api.modules.task.data.dto.TaskDto
import com.james.crm.api.modules.task.data.repository.TaskDataRepository
import com.james.crm.api.modules.task.data.usecase.contract.IAssignPipelineToTaskUsecase
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException
import org.springframework.http.HttpStatus.*
import org.springframework.http.ResponseEntity

@Usecase
class AssignPipelineToTaskUseCaseImpl(
    private val taskRepository: TaskDataRepository,
    private val pipelineRepository: PipelineDataRepository
) : IAssignPipelineToTaskUsecase {

    override fun execute(input: AssignPipelineToTaskInput): ResponseEntity<ApiResponse<TaskDto>> {
        return try {
            val task = taskRepository.findById(input.taskId).orElseThrow { Error("Task not found") }
            val pipeline = pipelineRepository.findById(input.pipelineId).orElseThrow { Error("Pipeline not found") }

            // Assign pipeline to task
            task.pipeline = pipeline

            val updatedTask = taskRepository.save(task)
            successResponse(OK, TaskDto.Companion.toRequest(updatedTask))
        } catch (ex: NotFoundException) {
            errorResponse(NOT_FOUND, CatchableError(NOT_FOUND, listOf(ex.localizedMessage), ex))
        } catch (ex: Exception) {
            errorResponse(INTERNAL_SERVER_ERROR, CatchableError(INTERNAL_SERVER_ERROR, listOf(ex.localizedMessage), ex))
        }
    }
}

