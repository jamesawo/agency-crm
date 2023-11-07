/*
 * @Author: james.aworo
 * @Date: 11/3/23
 *
 * @Project: agent-crm
 */

package com.james.crm.api.modules.people.domain.usecase

import com.james.crm.api.modules.people.domain.model.Client

interface IClientUsecase {
    fun find(clientId: String): Client

    fun create(client: Client): Client

    fun find(page: Int)
}
