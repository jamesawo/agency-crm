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
class Manager: Base() {

    @OneToOne(cascade = [CascadeType.ALL])
    val profile: Profile = Profile()

    @OneToOne(cascade = [CascadeType.ALL])
    val contact: Contact = Contact()

    @OneToOne(cascade = [CascadeType.ALL])
    val user: User = User()

    @OneToMany(mappedBy = "manager", fetch = FetchType.LAZY)
    val agents: List<Agent> = emptyList();
}