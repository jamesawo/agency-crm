/*
 * @Author: james.aworo
 * @Date: 11/1/23
 *
 * @Project: agent-crm
 */

package com.james.crm.api.modules.people.domain.model

import com.james.crm.api.core.model.Base
import jakarta.persistence.Entity
import jakarta.persistence.ManyToOne

@Entity
class Client : Base() {

    @ManyToOne()
    var agent: Agent = Agent()
}