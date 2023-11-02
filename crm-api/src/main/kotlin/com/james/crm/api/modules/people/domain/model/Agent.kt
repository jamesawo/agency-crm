/*
 * @Author: james.aworo
 * @Date: 11/1/23
 *
 * @Project: agent-crm
 */

package com.james.crm.api.modules.people.domain.model

import com.james.crm.api.configuration.core.model.Base
import com.james.crm.api.modules.people.domain.model.shared.*

class Agent: Base(){
    var profile: AgentProfile = AgentProfile()
    var contact: AgentContact = AgentContact()
    var emergencyContact: EmergencyContact = EmergencyContact()
    var user: User = User()
    var clients: MutableList<Client> = mutableListOf()
    var resources: MutableList<Resource> = mutableListOf()
    var task: Task = Task()
    var team: Team = Team()
    var location: Location = Location()
}