/*
 * @Author: james.aworo
 * @Date: 11/8/23
 *
 * @Project: agent-crm
 */

package com.james.crm.api.modules.people.data.usecase.implementation.agent

import com.james.crm.api.core.annotation.Usecase
import com.james.crm.api.modules.people.data.dto.LocationDto
import com.james.crm.api.modules.people.data.usecase.contract.agent.IAgentLocationUsecase
import com.james.crm.api.modules.people.domain.repository.AgentDataRepository
import org.springframework.http.ResponseEntity

@Usecase
class AgentLocationUsecase(
    private val repository: AgentDataRepository
) : IAgentLocationUsecase {
    override fun getLocation(agentId: String): ResponseEntity<LocationDto> {
        return repository.findById(agentId)
            .map { ResponseEntity.ok(it.location?.let { location -> LocationDto.toRequest(location) }) }
            .orElse(ResponseEntity.notFound().build())
    }

    override fun updateLocation(agentId: String, locationDto: LocationDto): ResponseEntity<LocationDto> {
        return repository.findById(agentId).map {
            it.location = LocationDto.toEntity(locationDto.apply { id = it.location?.id })
            ResponseEntity.ok(repository.save(it).location?.let { it1 -> LocationDto.toTrimRequest(it1) })
        }.orElse(ResponseEntity.notFound().build())
    }
}