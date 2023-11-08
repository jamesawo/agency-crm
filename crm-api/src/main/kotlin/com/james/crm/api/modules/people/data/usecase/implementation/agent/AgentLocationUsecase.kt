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
import org.springframework.http.ResponseEntity

@Usecase
class AgentLocationUsecase : IAgentLocationUsecase {
    override fun getLocation(agentId: String): ResponseEntity<LocationDto> {
        TODO()
    }

    override fun updateLocation(agentId: String, locationDto: LocationDto): ResponseEntity<LocationDto> {
        TODO()
    }
}