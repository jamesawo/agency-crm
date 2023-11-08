/*
 * @Author: james.aworo
 * @Date: 11/3/23
 *
 * @Project: agent-crm
 */

package com.james.crm.api.modules.people.data.usecase.interfaces

import com.james.crm.api.modules.people.data.dto.ClientDto
import com.james.crm.api.modules.people.domain.model.Client

interface IClientUsecase {
    fun find(clientId: String): ClientDto

    fun create(client: ClientDto): ClientDto

    fun find(page: Int)
}
