package com.james.crm.api.modules.people.data.dto

import com.fasterxml.jackson.annotation.JsonInclude
import com.james.crm.api.core.model.Mapper
import com.james.crm.api.modules.people.domain.model.Agent
import com.james.crm.api.modules.people.domain.model.Manager
import com.james.crm.api.modules.people.domain.model.UserTypeEnum
import jakarta.validation.Valid

@JsonInclude(JsonInclude.Include.NON_NULL)
class ManagerDto(
    var id: String? = null,

    @field:Valid
    var contact: ContactDto = ContactDto(),

    @field:Valid
    var profile: ProfileDto = ProfileDto(),

    @field:Valid
    var user: UserDto = UserDto(),

    var agents: MutableList<AgentDto> = mutableListOf()
) {
    constructor() : this(id = null)

    companion object : Mapper<ManagerDto, Manager> {
        override fun toEntity(request: ManagerDto): Manager {
            val manager = Manager()
            manager.profile = ProfileDto.toEntity(request.profile)
            manager.contact = ContactDto.toEntity(request.contact)
            manager.user = UserDto.toEntity(request.user).apply { userType = UserTypeEnum.MANAGER }
            manager.agents = request.agents.map { Agent(id = it.id) }
            return manager
        }

        override fun toRequest(entity: Manager): ManagerDto {
            return ManagerDto(
                id = entity.id,
                profile = ProfileDto.toTrimmedRequest(entity.profile),
                contact = ContactDto.toRequest(entity.contact),
                user = UserDto.toRequest(entity.user),
                agents = entity.agents.map { AgentDto.toRequest(it) }.toMutableList()
            )
        }
    }

}