package com.james.crm.api.modules.people.data.dto

import com.fasterxml.jackson.annotation.JsonInclude

@JsonInclude(JsonInclude.Include.NON_NULL)
class ManagerDto {
    val id: String? = null
    var profile: ProfileDto = ProfileDto()
    var contact: ContactDto = ContactDto()
    var user: UserDto = UserDto()
    var agents: MutableList<AgentDto> = mutableListOf()
}
