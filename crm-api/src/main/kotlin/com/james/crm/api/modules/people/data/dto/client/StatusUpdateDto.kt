/*
 * @Author: james.aworo
 * @Date: 11/18/23
 *
 * @Project: agent-crm
 */

package com.james.crm.api.modules.people.data.dto.client

import com.james.crm.api.modules.people.domain.enums.ClientStatus

data class StatusUpdateDto(
    val clientId: String,
    val status: ClientStatus
)
