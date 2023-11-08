/*
 * @Author: james.aworo
 * @Date: 11/8/23
 *
 * @Project: agent-crm
 */

package com.james.crm.api.modules.people.endpoint.agent

import com.james.crm.api.core.constant.Route
import com.james.crm.api.modules.people.data.dto.ProfileDto
import com.james.crm.api.modules.people.data.usecase.contract.agent.IAgentProfileUsecase
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*


@RestController
@RequestMapping("${Route.BASE}/agents/{agentId}/profile")
class AgentProfileEndpoint(
    private val profileUsecase: IAgentProfileUsecase
) {
    
    @GetMapping("/{id}/profile")
    fun getProfile(@PathVariable id: String): ResponseEntity<ProfileDto> {
        return profileUsecase.getProfile(id)
    }

    @PutMapping("/{id}/profile")
    fun updateProfile(@PathVariable id: String, @RequestBody profileDto: ProfileDto): ResponseEntity<ProfileDto> =
        profileUsecase.updateProfile(id, profileDto)

}