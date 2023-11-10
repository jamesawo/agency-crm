package com.james.crm.api.modules.people.data.dto

import com.fasterxml.jackson.annotation.JsonInclude
import com.james.crm.api.core.model.Mapper
import com.james.crm.api.modules.people.domain.model.Manager

@JsonInclude(JsonInclude.Include.NON_NULL)
class ManagerDto {
    val id: String? = null
    var profile: ProfileDto = ProfileDto()
    var contact: ContactDto = ContactDto()
    var user: UserDto = UserDto()
    var agents: MutableList<AgentDto> = mutableListOf()

    companion object : Mapper<ManagerDto, Manager> {
        override fun toEntity(request: ManagerDto): Manager {
            TODO("Not yet implemented")
        }

        override fun toRequest(entity: Manager): ManagerDto {
            TODO("Not yet implemented")
        }

    }
}
