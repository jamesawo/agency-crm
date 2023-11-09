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
    @GetMapping
    fun getProfile(@PathVariable agentId: String): ResponseEntity<ProfileDto> = profileUsecase.getProfile(agentId)

    @PutMapping
    fun updateProfile(
        @RequestBody profileDto: ProfileDto,
        @PathVariable agentId: String
    ): ResponseEntity<ProfileDto> = profileUsecase.updateProfile(agentId, profileDto)

    /*  @GetMapping("/{id}")
      fun getProfile(@PathVariable id: String, @PathVariable agentId: String): ResponseEntity<ProfileDto> =
          profileUsecase.getProfile(id)

      @PutMapping("/{id}")
      fun updateProfile(
          @PathVariable id: String,
          @RequestBody profileDto: ProfileDto,
          @PathVariable agentId: String
      ): ResponseEntity<ProfileDto> = profileUsecase.updateProfile(id, profileDto)*/

}