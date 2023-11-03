/*
 * @Author: james.aworo
 * @Date: 11/1/23
 *
 * @Project: agent-crm
 */

package com.james.crm.api.modules.people.domain.model.shared

import com.james.crm.api.core.model.Base
import com.james.crm.api.modules.people.domain.model.Agent
import com.james.crm.api.modules.people.domain.model.Client
import jakarta.persistence.Entity
import jakarta.persistence.ManyToOne

@Entity
open class Resource: Base() {

    @ManyToOne
    var agent: Agent = Agent()

    @ManyToOne
    var client: Client = Client()
}