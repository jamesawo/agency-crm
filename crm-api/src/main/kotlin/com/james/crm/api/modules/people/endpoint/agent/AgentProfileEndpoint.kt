/*
 * @Author: james.aworo
 * @Date: 11/8/23
 *
 * @Project: agent-crm
 */

package com.james.crm.api.modules.people.endpoint.agent

import com.james.crm.api.core.constant.Route.Companion.API_VERSION
import com.james.crm.api.modules.people.data.dto.ProfileDto
import com.james.crm.api.modules.people.data.usecase.contract.agent.IAgentProfileUsecase
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*


@RestController
@RequestMapping("$API_VERSION/agents/{agentId}/profile")
class AgentProfileEndpoint(
    private val profileUsecase: IAgentProfileUsecase
) {
    @GetMapping
    fun getProfile(@PathVariable agentId: String): ResponseEntity<ProfileDto> = profileUsecase.getProfile(agentId)

    @PutMapping
    fun updateProfile(
        @RequestBody profileDto: ProfileDto,
        @PathVariable agentId: String
    ): ResponseEntity<ProfileDto> = profileUsecase.updateProfile(agentId, profileDto)


}