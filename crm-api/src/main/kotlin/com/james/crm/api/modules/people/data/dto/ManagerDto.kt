package com.james.crm.api.modules.people.data.dto

import com.fasterxml.jackson.annotation.JsonInclude
import com.james.crm.api.core.model.Mapper
import com.james.crm.api.modules.people.domain.model.Agent
import com.james.crm.api.modules.people.domain.model.Manager

@JsonInclude(JsonInclude.Include.NON_NULL)
class ManagerDto {
    var id: String? = null
    var profile: ProfileDto = ProfileDto()
    var contact: ContactDto = ContactDto()
    var user: UserDto = UserDto()
    var agents: MutableList<AgentDto> = mutableListOf()

    constructor(
        id: String?,
        profile: ProfileDto,
        contact: ContactDto,
        user: UserDto,
        agents: MutableList<AgentDto>
    ) : this() {
        this.id = id
        this.profile = profile
        this.contact = contact
        this.user = user
        this.agents = agents
    }

    constructor()


    companion object : Mapper<ManagerDto, Manager> {
        override fun toEntity(request: ManagerDto): Manager {
            val manager = Manager()
            manager.profile = ProfileDto.toEntity(request.profile)
            manager.contact = ContactDto.toEntity(request.contact)
            manager.user = UserDto.toEntity(request.user)
            manager.agents = request.agents.map { Agent(id = it.id) }
            return manager
        }


        override fun toRequest(entity: Manager): ManagerDto {
            return ManagerDto(
                id = entity.id,
                profile = ProfileDto.toRequest(entity.profile),
                contact = ContactDto.toRequest(entity.contact),
                user = UserDto.toRequest(entity.user),
                agents = entity.agents.map { AgentDto.toRequest(it) }.toMutableList()
            )
        }
    }


}