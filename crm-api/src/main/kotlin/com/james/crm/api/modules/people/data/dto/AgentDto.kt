/*
 * @Author: james.aworo
 * @Date: 11/7/23
 *
 * @Project: agent-crm
 */

package com.james.crm.api.modules.people.data.dto

import com.james.crm.api.core.model.Mapper
import com.james.crm.api.modules.people.domain.model.Agent

data class AgentDto(val id: String) : Mapper<AgentDto, Agent> {
    var isActive: Boolean = true
    var profile: ProfileDto = ProfileDto()
    var contact: ContactDto = ContactDto()
    var emergencyContact: ContactDto = ContactDto()
    var user: UserDto = UserDto()
    var clients: MutableList<ClientDto> = mutableListOf()
    var resources: MutableList<ResourceDto> = mutableListOf()
    var task: TaskDto = TaskDto()
    var team: TeamDto = TeamDto()
    var location: LocationDto = LocationDto()
    var manager: ManagerDto = ManagerDto()


    override fun toRequest(entity: Agent): AgentDto {
        TODO("Not yet implemented")
    }

    override fun toEntity(): Agent {
        val agent = Agent()
        agent.profile = profile.toEntity()
        agent.contact = contact.toEntity()
        agent.emergencyContact = emergencyContact.toEntity()
        agent.user = user.toEntity()
        agent.location = location.toEntity()

        /*
        var clients: MutableList<Client> = mutableListOf()
        var task: Task = Task()
        var team: Team = Team()
        var manager: Manager = Manager()
        * */

        return agent
    }


}