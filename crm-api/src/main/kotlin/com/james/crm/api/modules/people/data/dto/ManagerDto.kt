package com.james.crm.api.modules.people.data.dto

class ManagerDto {
    val id: String? = null
    var profile: ProfileDto = ProfileDto()
    var contact: ContactDto = ContactDto()
    var user: UserDto = UserDto()
    var agents: MutableList<AgentDto> = mutableListOf();
}
