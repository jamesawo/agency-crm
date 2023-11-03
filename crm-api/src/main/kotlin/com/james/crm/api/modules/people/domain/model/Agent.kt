/*
 * @Author: james.aworo
 * @Date: 11/1/23
 *
 * @Project: agent-crm
 */

package com.james.crm.api.modules.people.domain.model

import com.james.crm.api.core.constant.TableConstant
import com.james.crm.api.core.model.Base
import com.james.crm.api.modules.people.domain.model.shared.*
import jakarta.persistence.*

@Entity
@Table(name = TableConstant.AGENT_TABLE)
class Agent: Base(){

    @OneToOne
    var profile: AgentProfile = AgentProfile()

    @OneToOne
    var contact: AgentContact = AgentContact()

    @OneToOne
    var emergencyContact: EmergencyContact = EmergencyContact()

    @OneToOne
    var user: User = User()

    @OneToMany(mappedBy = "agent")
    var clients: MutableList<Client> = mutableListOf()

    @OneToMany(mappedBy = "agent")
    var resources: MutableList<Resource> = mutableListOf()

    @ManyToOne
    var task: Task = Task()

    @ManyToOne
    var team: Team = Team()

    @OneToOne
    var location: Location = Location()
}