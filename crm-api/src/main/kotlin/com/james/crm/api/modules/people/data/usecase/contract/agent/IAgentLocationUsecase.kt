/*
 * @Author: james.aworo
 * @Date: 11/8/23
 *
 * @Project: agent-crm
 */

package com.james.crm.api.modules.people.data.usecase.contract.agent

import com.james.crm.api.core.common.ApiResponse
import com.james.crm.api.modules.people.data.dto.LocationDto
import org.springframework.http.ResponseEntity

interface IAgentLocationUsecase {
    fun getLocation(agentId: String): ResponseEntity<ApiResponse<LocationDto?>>
    fun updateLocation(agentId: String, locationDto: LocationDto): ResponseEntity<ApiResponse<LocationDto?>>
}
