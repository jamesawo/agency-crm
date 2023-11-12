/*
 * @Author: james.aworo
 * @Date: 11/8/23
 *
 * @Project: agent-crm
 */

package com.james.crm.api.modules.people.data.usecase.contract.manager

import com.james.crm.api.core.common.ApiResponse
import com.james.crm.api.modules.people.data.dto.UserDto
import org.springframework.http.ResponseEntity

interface IManagerUserUsecase {
    fun getUser(managerId: String): ResponseEntity<ApiResponse<UserDto>>
    fun updateUser(managerId: String, userDto: UserDto): ResponseEntity<ApiResponse<UserDto>>
}