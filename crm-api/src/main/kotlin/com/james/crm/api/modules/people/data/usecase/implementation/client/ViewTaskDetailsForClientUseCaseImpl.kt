/*
 * @Author: james.aworo
 * @Date: 11/18/23
 *
 * @Project: agent-crm
 */

package com.james.crm.api.modules.people.data.usecase.implementation.client

import com.james.crm.api.core.annotation.Usecase
import com.james.crm.api.core.common.ApiResponse
import com.james.crm.api.core.common.CatchableError
import com.james.crm.api.core.util.Util.Companion.errorResponse
import com.james.crm.api.core.util.Util.Companion.notFoundMessageAsList
import com.james.crm.api.core.util.Util.Companion.successResponse
import com.james.crm.api.modules.people.data.usecase.contract.client.IViewTaskDetailsForClientUsecase
import com.james.crm.api.modules.people.domain.repository.ClientDataRepository
import com.james.crm.api.modules.task.data.dto.TaskDto
import org.springframework.http.HttpStatus.*
import org.springframework.http.ResponseEntity

@Usecase
class ViewTaskDetailsForClientUseCaseImpl(
    private val clientRepository: ClientDataRepository
) : IViewTaskDetailsForClientUsecase {

    override fun execute(input: String): ResponseEntity<ApiResponse<TaskDto?>> {
        return try {
            clientRepository.findById(input).map { client ->
                val taskDto = client.task?.let { TaskDto.toRequest(it) }
                successResponse(OK, taskDto)
            }.orElse(errorResponse(NOT_FOUND, notFoundMessageAsList("client")))
        } catch (ex: Exception) {
            errorResponse(INTERNAL_SERVER_ERROR, CatchableError(INTERNAL_SERVER_ERROR, ex))
        }
    }
}
