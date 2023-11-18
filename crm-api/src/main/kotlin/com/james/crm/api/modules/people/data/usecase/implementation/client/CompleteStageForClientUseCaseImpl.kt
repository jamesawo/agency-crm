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
import com.james.crm.api.modules.people.data.dto.client.StageCompletionDto
import com.james.crm.api.modules.people.data.usecase.contract.client.ICompleteStageForClientUsecase
import com.james.crm.api.modules.people.domain.repository.ClientDataRepository
import com.james.crm.api.modules.pipeline.data.repository.StageDataRepository
import com.james.crm.api.modules.pipeline.domain.enums.StageStatus
import org.springframework.http.HttpStatus.*
import org.springframework.http.ResponseEntity


@Usecase
class CompleteStageForClientUseCaseImpl(
    private val clientRepository: ClientDataRepository,
    private val stageRepository: StageDataRepository
) : ICompleteStageForClientUsecase {

    override fun execute(input: StageCompletionDto): ResponseEntity<ApiResponse<Boolean>> {
        return try {
            clientRepository.findById(input.clientId).map { client ->
                val completedStage = client.task?.pipeline?.stages?.find { it.id == input.stageId }
                completedStage?.let {
                    it.status = StageStatus.COMPLETED
                    stageRepository.save(it)
                    //clientRepository.save(client)
                    successResponse(OK, true)
                } ?: successResponse(OK, false)
            }.orElse(errorResponse(NOT_FOUND, notFoundMessageAsList("client")))
        } catch (ex: Exception) {
            errorResponse(INTERNAL_SERVER_ERROR, CatchableError(INTERNAL_SERVER_ERROR, ex))
        }
    }
}
