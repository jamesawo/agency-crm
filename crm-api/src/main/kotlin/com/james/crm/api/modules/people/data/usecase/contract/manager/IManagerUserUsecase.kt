/*
 * @Author: james.aworo
 * @Date: 11/8/23
 *
 * @Project: agent-crm
 */

package com.james.crm.api.modules.people.data.usecase.contract.manager

import com.james.crm.api.modules.people.data.dto.UserDto
import org.springframework.http.ResponseEntity

interface IManagerUserUsecase {
    fun getUser(managerId: String): ResponseEntity<UserDto>
    fun updateUser(managerId: String, userDto: UserDto): ResponseEntity<UserDto>
}