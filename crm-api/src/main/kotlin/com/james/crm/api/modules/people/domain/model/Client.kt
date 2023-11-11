/*
 * @Author: james.aworo
 * @Date: 11/1/23
 *
 * @Project: agent-crm
 */

package com.james.crm.api.modules.people.domain.model

import com.james.crm.api.core.common.Base
import com.james.crm.api.core.constant.DatabaseTable.Companion.CLIENT
import jakarta.persistence.Entity
import jakarta.persistence.FetchType
import jakarta.persistence.ManyToOne
import jakarta.persistence.Table

@Entity
@Table(name = CLIENT)
class Client : Base() {
    var firstName: String = ""
    var lastName: String = ""
    var businessName: String = ""
    var email: String = ""
    var phone: String = ""

    @ManyToOne(fetch = FetchType.LAZY)
    var agent: Agent = Agent()
}