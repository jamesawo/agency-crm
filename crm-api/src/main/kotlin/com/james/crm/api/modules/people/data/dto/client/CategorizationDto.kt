/*
 * @Author: james.aworo
 * @Date: 11/18/23
 *
 * @Project: agent-crm
 */

package com.james.crm.api.modules.people.data.dto.client

data class CategorizationDto(
    val clientId: String,
    val tags: Set<String>
)
