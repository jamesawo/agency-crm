/*
 * @Author: james.aworo
 * @Date: 11/1/23
 *
 * @Project: agent-crm
 */

package com.james.crm.api.modules.people.domain.model

import com.james.crm.api.core.constant.DatabaseTable.Companion.MANAGER
import com.james.crm.api.core.model.Base
import com.james.crm.api.modules.people.domain.model.submodel.Contact
import com.james.crm.api.modules.people.domain.model.submodel.Profile
import jakarta.persistence.*

@Entity
@Table(name = MANAGER)
class Manager(id: String?) : Base(id) {

    @OneToOne(cascade = [CascadeType.ALL])
    var profile: Profile = Profile()

    @OneToOne(cascade = [CascadeType.ALL])
    var contact: Contact = Contact()

    @OneToOne(cascade = [CascadeType.ALL])
    var user: User = User()

    @OneToMany(mappedBy = "manager", fetch = FetchType.LAZY)
    var agents: List<Agent> = emptyList()

    constructor() : this(id = null)
}