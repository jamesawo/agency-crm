/*
 * @Author: james.aworo
 * @Date: 11/3/23
 *
 * @Project: agent-crm
 */

package com.james.crm.api.modules.people.domain.usecase

import com.james.crm.api.modules.people.domain.model.Manager

interface IManagerUsecase{
    fun create(manager: Manager): Manager

    fun find(managerId: String): Manager?

    fun update(manager: Manager): Manager
}
