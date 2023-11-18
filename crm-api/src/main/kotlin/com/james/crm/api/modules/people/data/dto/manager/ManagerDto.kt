package com.james.crm.api.modules.people.data.dto.manager

import com.fasterxml.jackson.annotation.JsonInclude
import com.james.crm.api.core.common.Mapper
import com.james.crm.api.modules.people.data.dto.agent.AgentDto
import com.james.crm.api.modules.people.data.dto.other.ContactDto
import com.james.crm.api.modules.people.data.dto.other.ProfileDto
import com.james.crm.api.modules.people.data.dto.other.UserDto
import com.james.crm.api.modules.people.domain.enums.UserTypeEnum
import com.james.crm.api.modules.people.domain.model.Agent
import com.james.crm.api.modules.people.domain.model.Manager
import jakarta.validation.Valid

@JsonInclude(JsonInclude.Include.NON_NULL)
class ManagerDto(
    var id: String? = null,

    @field:Valid
    var contact: ContactDto = ContactDto(),

    @field:Valid
    var profile: ProfileDto = ProfileDto(),

    @field:Valid
    var user: UserDto? = UserDto(),

    var agents: MutableList<AgentDto>? = mutableListOf()
) {
    constructor() : this(id = null)

    constructor(id: String?, profile: ProfileDto, contact: ContactDto) : this() {
        this.id = id
        this.profile = profile
        this.contact = contact
    }

    companion object : Mapper<ManagerDto, Manager> {
        override fun toEntity(request: ManagerDto): Manager {
            return Manager(
                id = request.id,
                profile = ProfileDto.toEntity(request.profile),
                contact = ContactDto.toEntity(request.contact),
                user = UserDto.toEntity(request.user ?: UserDto()).apply { userType = UserTypeEnum.MANAGER },
                agents = request.agents?.map { Agent(id = it.id) } ?: emptyList(),
            )
        }

        override fun toRequest(entity: Manager): ManagerDto {
            return ManagerDto(
                id = entity.id,
                profile = ProfileDto.toTrimRequest(entity.profile),
                contact = ContactDto.toRequest(entity.contact),
                user = UserDto.toRequest(entity.user),
                agents = entity.agents.map { AgentDto.toRequest(it) }.toMutableList()
            )
        }

        override fun toTrimRequest(entity: Manager): ManagerDto {
            return ManagerDto(
                id = entity.id,
                profile = ProfileDto.toTrimRequest(entity.profile),
                contact = ContactDto.toRequest(entity.contact),
                user = null,
                agents = null
            )
        }
    }

}