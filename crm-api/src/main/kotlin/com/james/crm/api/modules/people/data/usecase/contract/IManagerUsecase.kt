/*
 * @Author: james.aworo
 * @Date: 11/3/23
 *
 * @Project: agent-crm
 */

package com.james.crm.api.modules.people.data.usecase.interfaces

import com.james.crm.api.modules.people.data.dto.ManagerDto

interface IManagerUsecase{
    fun create(manager: ManagerDto): ManagerDto

    fun find(managerId: String): ManagerDto?

    fun update(manager: ManagerDto): ManagerDto
}
