/*
 * @Author: james.aworo
 * @Date: 11/1/23
 *
 * @Project: agent-crm
 */

package com.james.crm.api.modules.people.domain.model

import com.james.crm.api.core.common.Base
import com.james.crm.api.core.constant.DatabaseTable.Companion.AGENT
import com.james.crm.api.modules.people.domain.model.submodel.*
import com.james.crm.api.modules.team.domain.Team
import jakarta.persistence.*

@Entity
@Table(name = AGENT)
class Agent(
    id: String? = null
) : Base(id) {

    @OneToOne(cascade = [CascadeType.ALL])
    var profile: Profile = Profile()

    @OneToOne(cascade = [CascadeType.ALL])
    var contact: Contact = Contact()

    @OneToOne(fetch = FetchType.LAZY, cascade = [CascadeType.ALL])
    var emergencyContact: EmergencyContact = EmergencyContact()

    @OneToOne(fetch = FetchType.LAZY, cascade = [CascadeType.ALL])
    var user: User = User()

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "agent", cascade = [CascadeType.ALL])
    var clients: MutableList<Client> = mutableListOf()

    @ManyToOne(fetch = FetchType.LAZY, cascade = [CascadeType.ALL])
    var task: Task? = null

    @ManyToOne(fetch = FetchType.LAZY, cascade = [CascadeType.ALL])
    var team: Team? = null

    @OneToOne(fetch = FetchType.LAZY, cascade = [CascadeType.ALL])
    var location: Location? = null

    @ManyToOne(fetch = FetchType.LAZY, cascade = [CascadeType.ALL])
    var manager: Manager? = null

}