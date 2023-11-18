/*
 * @Author: james.aworo
 * @Date: 11/8/23
 *
 * @Project: agent-crm
 */

package com.james.crm.api.modules.people.endpoint.manager

import com.james.crm.api.core.common.ApiResponse
import com.james.crm.api.core.constant.Route.Companion.API_VERSION
import com.james.crm.api.modules.people.data.dto.other.ProfileDto
import com.james.crm.api.modules.people.data.usecase.contract.manager.IManagerProfileUsecase
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*


@RestController
@RequestMapping("$API_VERSION/managers/{managerId}/profile")
class ManagerProfileEndpoint(
    private val profileUsecase: IManagerProfileUsecase
) {
    @GetMapping
    fun getProfile(
        @PathVariable managerId: String
    ): ResponseEntity<ApiResponse<ProfileDto>> {
        return profileUsecase.getProfile(managerId)
    }

    @PutMapping
    fun updateProfile(
        @RequestBody profileDto: ProfileDto,
        @PathVariable managerId: String
    ): ResponseEntity<ApiResponse<ProfileDto>> {
        return profileUsecase.updateProfile(managerId, profileDto)
    }


}