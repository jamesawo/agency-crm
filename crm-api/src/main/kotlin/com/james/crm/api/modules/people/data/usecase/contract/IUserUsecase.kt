/*
 * @Author: james.aworo
 * @Date: 11/3/23
 *
 * @Project: agent-crm
 */

package com.james.crm.api.modules.people.data.usecase.contract

import com.james.crm.api.modules.people.data.dto.UserDto

interface IUserUsecase{
    fun create(user: UserDto): UserDto

    fun update(user: UserDto): UserDto

    fun assignRole(roleId: String): Boolean

    fun find(userId: String): UserDto?
}
