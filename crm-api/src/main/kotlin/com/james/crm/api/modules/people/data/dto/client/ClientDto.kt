package com.james.crm.api.modules.people.data.dto

import com.fasterxml.jackson.annotation.JsonInclude

@JsonInclude(JsonInclude.Include.NON_NULL)
class ClientDto(val id: String? = null) {
    var firstName: String = ""
    var lastName: String = ""
    var businessName: String = ""
    var email: String = ""
    var phone: String = ""
    var agent: AgentDto = AgentDto()
    
    constructor(
        id: String?,
        firstName: String = "",
        lastName: String = "",
        businessName: String = "",
        email: String = "",
        phone: String = "",
        agent: AgentDto = AgentDto(),
    ) : this(id)
}
