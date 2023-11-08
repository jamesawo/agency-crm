/*
 * @Author: james.aworo
 * @Date: 11/8/23
 *
 * @Project: agent-crm
 */

package com.james.crm.api.modules.people.data.usecase.contract.agent

import com.james.crm.api.modules.people.data.dto.ProfileDto
import org.springframework.http.ResponseEntity

interface IAgentProfileUsecase {
    fun getProfile(agentId: String): ResponseEntity<ProfileDto>
    fun updateProfile(agentId: String, profileDto: ProfileDto): ResponseEntity<ProfileDto>
}