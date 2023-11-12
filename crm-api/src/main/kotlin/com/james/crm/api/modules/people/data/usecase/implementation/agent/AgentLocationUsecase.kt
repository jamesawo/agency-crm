/*
 * @Author: james.aworo
 * @Date: 11/8/23
 *
 * @Project: agent-crm
 */

package com.james.crm.api.modules.people.data.usecase.implementation.agent

import com.james.crm.api.core.annotation.Usecase
import com.james.crm.api.core.common.ApiResponse
import com.james.crm.api.core.util.Util.Companion.errorResponse
import com.james.crm.api.core.util.Util.Companion.notFoundMessageAsList
import com.james.crm.api.core.util.Util.Companion.successResponse
import com.james.crm.api.modules.people.data.dto.LocationDto
import com.james.crm.api.modules.people.data.usecase.contract.agent.IAgentLocationUsecase
import com.james.crm.api.modules.people.domain.repository.AgentDataRepository
import org.springframework.http.HttpStatus.NOT_FOUND
import org.springframework.http.HttpStatus.OK
import org.springframework.http.ResponseEntity

@Usecase
class AgentLocationUsecase(
    private val repository: AgentDataRepository
) : IAgentLocationUsecase {
    override fun getLocation(agentId: String): ResponseEntity<ApiResponse<LocationDto?>> {
        return repository.findById(agentId).map { agent ->
            val locationDto = agent.location?.let { location -> LocationDto.toRequest(location) }
            successResponse(OK, locationDto)
        }.orElse(errorResponse(NOT_FOUND, notFoundMessageAsList("agent")))
    }

    override fun updateLocation(agentId: String, locationDto: LocationDto): ResponseEntity<ApiResponse<LocationDto?>> {
        return repository.findById(agentId).map { agent ->
            agent.location = LocationDto.toEntity(locationDto.apply { id = agent.location?.id })
            successResponse(OK, repository.save(agent).location?.let { it1 -> LocationDto.toTrimRequest(it1) })
        }.orElse(errorResponse(NOT_FOUND, notFoundMessageAsList("agent")))
    }
}