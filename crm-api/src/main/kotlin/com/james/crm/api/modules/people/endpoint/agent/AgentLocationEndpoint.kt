/*
 * @Author: james.aworo
 * @Date: 11/8/23
 *
 * @Project: agent-crm
 */

package com.james.crm.api.modules.people.endpoint.agent

import com.james.crm.api.core.constant.Route
import com.james.crm.api.modules.people.data.dto.LocationDto
import com.james.crm.api.modules.people.data.usecase.contract.agent.IAgentLocationUsecase
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("${Route.API_VERSION}/agents/{agentId}/location")
class AgentLocationEndpoint(
    private val locationUsecase: IAgentLocationUsecase
) {

    @GetMapping("/{id}/location")
    fun getLocation(@PathVariable id: String, @PathVariable agentId: String): ResponseEntity<LocationDto> =
        locationUsecase.getLocation(id)

    @PutMapping("/{id}/location")
    fun updateLocation(
        @PathVariable id: String,
        @RequestBody locationDto: LocationDto,
        @PathVariable agentId: String
    ): ResponseEntity<LocationDto> {
        return locationUsecase.updateLocation(id, locationDto)
    }

}
