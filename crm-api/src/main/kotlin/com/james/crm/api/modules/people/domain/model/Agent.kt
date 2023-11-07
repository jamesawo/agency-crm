/*
 * @Author: james.aworo
 * @Date: 11/1/23
 *
 * @Project: agent-crm
 */

package com.james.crm.api.modules.people.domain.model

import com.james.crm.api.core.constant.DatabaseTable.Companion.AGENT
import com.james.crm.api.core.model.Base
import com.james.crm.api.modules.people.domain.model.submodel.*
import jakarta.persistence.*

@Entity
@Table(name = AGENT)
class Agent: Base(){

    @OneToOne(cascade = [CascadeType.ALL])
    var profile: Profile = Profile()

    @OneToOne(cascade = [CascadeType.ALL])
    var contact: Contact = Contact()

    @OneToOne(cascade = [CascadeType.ALL])
    var emergencyContact: Contact = Contact()

    @OneToOne(cascade =  [CascadeType.ALL])
    var user: User = User()

    @OneToMany(mappedBy = "agent", cascade = [CascadeType.ALL])
    var clients: MutableList<Client> = mutableListOf()

    @ManyToOne(cascade = [CascadeType.ALL])
    var task: Task = Task()

    @ManyToOne(cascade = [CascadeType.ALL])
    var team: Team = Team()

    @OneToOne(cascade = [CascadeType.ALL])
    var location: Location = Location()

    @ManyToOne(cascade = [CascadeType.ALL])
    var manager: Manager = Manager()

}