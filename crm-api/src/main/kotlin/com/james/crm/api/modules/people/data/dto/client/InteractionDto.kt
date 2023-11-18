/*
 * @Author: james.aworo
 * @Date: 11/18/23
 *
 * @Project: agent-crm
 */

package com.james.crm.api.modules.people.data.dto.client

import com.james.crm.api.modules.people.domain.enums.InteractionType
import com.james.crm.api.modules.people.domain.model.submodel.Resource
import java.time.LocalDate

data class InteractionDto(var clientId: String? = null) {
    var interactionDate: LocalDate? = null
    var interactionType: InteractionType? = null
    val notes: String? = null
    val resources: Resource? = null
}
