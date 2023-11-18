/*
 * @Author: james.aworo
 * @Date: 11/8/23
 *
 * @Project: agent-crm
 */

package com.james.crm.api.modules.people.data.usecase.contract.manager

import com.james.crm.api.core.common.ApiResponse
import com.james.crm.api.modules.people.data.dto.other.ProfileDto
import org.springframework.http.ResponseEntity

interface IManagerProfileUsecase {
    fun getProfile(managerId: String): ResponseEntity<ApiResponse<ProfileDto>>
    fun updateProfile(managerId: String, profileDto: ProfileDto): ResponseEntity<ApiResponse<ProfileDto>>
}