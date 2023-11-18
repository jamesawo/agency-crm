package com.james.crm.api.modules.people.data.dto

import com.fasterxml.jackson.annotation.JsonInclude

@JsonInclude(JsonInclude.Include.NON_NULL)
class ResourceDto {
    var title: String = ""
    var type: String = ""
    var url: String = ""
    var owner: UserDto = UserDto()
}
