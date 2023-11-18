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
import com.james.crm.api.modules.people.data.dto.other.UserDto
import com.james.crm.api.modules.people.data.usecase.contract.manager.IManagerUserUsecase
import com.james.crm.api.modules.people.domain.repository.ManagerDataRepository
import org.springframework.http.HttpStatus
import org.springframework.http.HttpStatus.NOT_FOUND
import org.springframework.http.ResponseEntity

@Usecase
class ManagerUserUsecase(
    private val managerRepo: ManagerDataRepository
) : IManagerUserUsecase {

    override fun getUser(managerId: String): ResponseEntity<ApiResponse<UserDto>> {
        return managerRepo.findById(managerId).map {
            successResponse(HttpStatus.OK, UserDto.toTrimRequest(it.user))
        }.orElse(errorResponse(NOT_FOUND, notFoundMessageAsList("manager")))
    }

    override fun updateUser(managerId: String, userDto: UserDto): ResponseEntity<ApiResponse<UserDto>> {
        return managerRepo.findById(managerId).map {
            it.user = UserDto.toEntity(userDto.apply { id = it.user.id; password = it.user.password })
            successResponse(HttpStatus.OK, UserDto.toTrimRequest(managerRepo.save(it).user))
        }.orElse(errorResponse(NOT_FOUND, notFoundMessageAsList("manager")))
    }
}