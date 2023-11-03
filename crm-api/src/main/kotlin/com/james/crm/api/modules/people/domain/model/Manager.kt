/*
 * @Author: james.aworo
 * @Date: 11/1/23
 *
 * @Project: agent-crm
 */

package com.james.crm.api.modules.people.domain.model

import com.james.crm.api.core.model.Base
import com.james.crm.api.modules.people.domain.model.shared.ManagerContact
import com.james.crm.api.modules.people.domain.model.shared.ManagerProfile
import jakarta.persistence.Entity
import jakarta.persistence.OneToOne

@Entity
class Manager: Base() {

    @OneToOne
    lateinit var profile: ManagerProfile

    @OneToOne
    lateinit var contact: ManagerContact

    @OneToOne
    lateinit var user: User
}