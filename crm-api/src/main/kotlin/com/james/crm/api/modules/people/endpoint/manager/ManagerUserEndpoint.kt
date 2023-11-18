/*
 * @Author: james.aworo
 * @Date: 11/8/23
 *
 * @Project: agent-crm
 */

package com.james.crm.api.modules.people.endpoint.manager

import com.james.crm.api.core.common.ApiResponse
import com.james.crm.api.core.constant.Route
import com.james.crm.api.modules.people.data.dto.other.UserDto
import com.james.crm.api.modules.people.data.usecase.contract.manager.IManagerUserUsecase
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("${Route.API_VERSION}/managers/{managerId}/user")
class ManagerUserEndpoint(
    private val userUsecase: IManagerUserUsecase
) {
    @GetMapping
    fun getUser(
        @PathVariable managerId: String
    ): ResponseEntity<ApiResponse<UserDto>> {
        return userUsecase.getUser(managerId)
    }

    @PutMapping
    fun updateUser(
        @RequestBody userDto: UserDto,
        @PathVariable managerId: String
    ): ResponseEntity<ApiResponse<UserDto>> {
        return userUsecase.updateUser(managerId, userDto)
    }

}