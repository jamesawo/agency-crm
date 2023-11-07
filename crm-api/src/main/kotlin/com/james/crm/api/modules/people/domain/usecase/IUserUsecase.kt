/*
 * @Author: james.aworo
 * @Date: 11/3/23
 *
 * @Project: agent-crm
 */

package com.james.crm.api.modules.people.domain.usecase

import com.james.crm.api.modules.people.domain.model.User

interface IUserUsecase{
    fun create(user: User): User

    fun update(user: User): User

    fun assignRole(roleId: String): Boolean

    fun find(userId: String): User?
}
