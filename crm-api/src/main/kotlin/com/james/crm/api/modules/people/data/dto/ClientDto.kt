package com.james.crm.api.modules.people.data.dto

class ClientDto {
    val id: String? = null
    var firstName: String = ""
    var lastName: String = ""
    var businessName: String = ""
    var email: String = ""
    var phone: String = ""
    var agent: AgentDto = AgentDto()
}
