/*
 * @Author: james.aworo
 * @Date: 11/7/23
 *
 * @Project: agent-crm
 */

package com.james.crm.api.modules.people.data.dto

import com.fasterxml.jackson.annotation.JsonInclude
import com.james.crm.api.core.model.Mapper
import com.james.crm.api.modules.people.domain.model.Agent


@JsonInclude(JsonInclude.Include.NON_NULL)
data class AgentDto(var id: String?) : Mapper<AgentDto, Agent> {
    var isActive: Boolean = true
    var profile: ProfileDto = ProfileDto()
    var contact: ContactDto = ContactDto()
    var emergencyContact: ContactDto? = ContactDto()
    var user: UserDto = UserDto()
    var clients: MutableList<ClientDto>? = mutableListOf()
    var resources: MutableList<ResourceDto>? = mutableListOf()
    var task: TaskDto? = TaskDto()
    var team: TeamDto? = TeamDto()
    var location: LocationDto? = LocationDto()
    var manager: ManagerDto? = ManagerDto()

    constructor() : this(id = null)

    override fun toRequest(entity: Agent): AgentDto {
        return this.apply {
            id = entity.id
            isActive = entity.isActive
            profile = profile.toRequest(entity.profile)
            contact = contact.toRequest(entity.contact)
            emergencyContact = entity.emergencyContact?.let { emergencyContact?.toRequest(it) }
            location = entity.location?.let { location?.toRequest(it) }
            user = user.toRequest(entity.user)
        }
    }

    override fun toEntity(): Agent {
        val agent = Agent()
        agent.profile = profile.toEntity()
        agent.contact = contact.toEntity()
        agent.emergencyContact = emergencyContact?.toEntity()
        agent.user = user.toEntity()
        agent.location = location?.toEntity()
        return agent
    }

    override fun toTrimmedRequest(entity: Agent): AgentDto {
        return toRequest(entity).apply {
            manager = null
            location = null
            emergencyContact = null
            task = null
            team = null
            clients = null
            resources = null
            profile.bankAccount = null
            profile.virtualBankAccount = null
        }
    }
}

