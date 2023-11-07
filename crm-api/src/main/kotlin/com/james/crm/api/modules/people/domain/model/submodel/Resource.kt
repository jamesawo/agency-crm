/*
 * @Author: james.aworo
 * @Date: 11/1/23
 *
 * @Project: agent-crm
 */

package com.james.crm.api.modules.people.domain.model.shared

import com.james.crm.api.core.model.Base
import com.james.crm.api.modules.people.domain.model.Agent
import jakarta.persistence.Entity
import jakarta.persistence.FetchType
import jakarta.persistence.ManyToOne

@Entity
open class Resource: Base() {

    @ManyToOne(fetch = FetchType.LAZY)
    var agent: Agent = Agent()

}