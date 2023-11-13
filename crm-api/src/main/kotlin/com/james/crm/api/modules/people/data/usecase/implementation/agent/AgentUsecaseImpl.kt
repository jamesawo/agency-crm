/*
 * @Author: james.aworo
 * @Date: 11/7/23
 *
 * @Project: agent-crm
 */

package com.james.crm.api.modules.people.data.usecase.implementation.agent

import com.james.crm.api.core.annotation.Usecase
import com.james.crm.api.core.common.ApiResponse
import com.james.crm.api.core.common.CatchableError
import com.james.crm.api.core.util.Util.Companion.errorResponse
import com.james.crm.api.core.util.Util.Companion.notFoundMessageAsList
import com.james.crm.api.core.util.Util.Companion.successResponse
import com.james.crm.api.modules.people.data.dto.AgentDto
import com.james.crm.api.modules.people.data.usecase.contract.agent.IAgentUsecase
import com.james.crm.api.modules.people.domain.repository.AgentDataRepository
import org.springframework.http.HttpStatus.*
import org.springframework.http.ResponseEntity

@Usecase
class AgentUsecaseImpl(
    private val repository: AgentDataRepository
) : IAgentUsecase {
    override fun create(agent: AgentDto): ResponseEntity<ApiResponse<AgentDto>> {
        return try {
            val saved = repository.save(AgentDto.toEntity(agent))
            successResponse(OK, AgentDto.toTrimRequest(saved))
        } catch (ex: Exception) {
            errorResponse(INTERNAL_SERVER_ERROR, CatchableError(INTERNAL_SERVER_ERROR, listOf(ex.localizedMessage), ex))
        }
    }

    override fun remove(id: String): ResponseEntity<ApiResponse<Boolean>> {
        return this.repository.findById(id).map { agent ->
            this.repository.delete(agent)
            successResponse(OK, true)
        }.orElse(errorResponse(NOT_FOUND, notFoundMessageAsList("agent")))
    }
}

