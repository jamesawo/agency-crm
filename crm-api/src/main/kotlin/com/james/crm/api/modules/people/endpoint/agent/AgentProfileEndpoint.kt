/*
 * @Author: james.aworo
 * @Date: 11/8/23
 *
 * @Project: agent-crm
 */

package com.james.crm.api.modules.people.endpoint.agent

import com.james.crm.api.core.common.ApiResponse
import com.james.crm.api.core.constant.Route.Companion.API_VERSION
import com.james.crm.api.modules.people.data.dto.other.ProfileDto
import com.james.crm.api.modules.people.data.usecase.contract.agent.IAgentProfileUsecase
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*


@RestController
@RequestMapping("$API_VERSION/agents/{agentId}/profile")
class AgentProfileEndpoint(
    private val profileUsecase: IAgentProfileUsecase
) {
    @GetMapping
    fun getProfile(@PathVariable agentId: String): ResponseEntity<ApiResponse<ProfileDto>> {
        return profileUsecase.getProfile(agentId)
    }

    @PutMapping
    fun updateProfile(
        @RequestBody profileDto: ProfileDto,
        @PathVariable agentId: String
    ): ResponseEntity<ApiResponse<ProfileDto>> {
        return profileUsecase.updateProfile(agentId, profileDto)
    }


}