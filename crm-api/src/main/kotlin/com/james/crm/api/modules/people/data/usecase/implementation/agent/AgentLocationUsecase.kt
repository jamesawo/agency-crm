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
            .map { ResponseEntity.ok(it.location?.let { it1 -> LocationDto.toRequest(it1) }) }
            .orElse(ResponseEntity.notFound().build())
    }

    override fun updateLocation(agentId: String, locationDto: LocationDto): ResponseEntity<LocationDto> {
        val optional = repository.findById(agentId)
        return optional.map {
            it.location = LocationDto.toEntity(locationDto)
            val agent = repository.save(it)
            ResponseEntity.ok(agent.location?.let { it1 -> LocationDto.toTrimmedRequest(it1) })
        }.orElse(ResponseEntity.notFound().build())
    }
}