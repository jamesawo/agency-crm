/*
 * @Author: james.aworo
 * @Date: 11/8/23
 *
 * @Project: agent-crm
 */

package com.james.crm.api.modules.people.data.usecase.implementation.manager

import com.james.crm.api.core.annotation.Usecase
import com.james.crm.api.core.common.ApiResponse
import com.james.crm.api.core.util.Util.Companion.errorResponse
import com.james.crm.api.core.util.Util.Companion.notFoundMessageAsList
import com.james.crm.api.core.util.Util.Companion.successResponse
import com.james.crm.api.modules.people.data.dto.ProfileDto
import com.james.crm.api.modules.people.data.usecase.contract.manager.IManagerProfileUsecase
import com.james.crm.api.modules.people.domain.repository.ManagerDataRepository
import org.springframework.http.HttpStatus.NOT_FOUND
import org.springframework.http.HttpStatus.OK
import org.springframework.http.ResponseEntity

@Usecase
class ManagerProfileUsecase(
    private val repository: ManagerDataRepository,
) : IManagerProfileUsecase {
    override fun getProfile(managerId: String): ResponseEntity<ApiResponse<ProfileDto>> {
        return repository.findById(managerId).map {
            successResponse(OK, ProfileDto.toTrimRequest(it.profile))
        }.orElse(errorResponse(NOT_FOUND, notFoundMessageAsList("manager")))
    }

    override fun updateProfile(managerId: String, profileDto: ProfileDto): ResponseEntity<ApiResponse<ProfileDto>> {
        return repository.findById(managerId).map {
            it.profile = ProfileDto.toEntity(profileDto.apply { id = it.profile.id })
            successResponse(OK, ProfileDto.toTrimRequest(repository.save(it).profile))
        }.orElse(errorResponse(NOT_FOUND, notFoundMessageAsList("manager")))
    }
}