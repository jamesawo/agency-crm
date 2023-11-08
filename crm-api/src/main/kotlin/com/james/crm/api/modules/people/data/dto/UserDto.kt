package com.james.crm.api.modules.people.data.dto

import com.fasterxml.jackson.annotation.JsonInclude
import com.fasterxml.jackson.annotation.JsonProperty
import com.james.crm.api.core.model.Mapper
import com.james.crm.api.modules.people.domain.model.User
import com.james.crm.api.modules.people.domain.model.UserTypeEnum
import java.time.LocalDate

@JsonInclude(JsonInclude.Include.NON_NULL)
class UserDto(var id: String?) : Mapper<UserDto, User> {
    var username: String = ""
    var isEnabled: Boolean = true
    var expiryDate: LocalDate = LocalDate.now().plusDays(365)
    var userType: UserTypeEnum = UserTypeEnum.AGENT

    // This field can be set, but it won't be serialized
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    var password: String = ""

    constructor() : this(id = null)

    override fun toEntity(): User {
        val user = User()
        user.userType = userType
        user.expiryDate = expiryDate
        user.isEnabled = isEnabled
        user.username = username
        //todo:: implement security
        user.password = password
        return user
    }

    override fun toRequest(entity: User): UserDto {
        return this.apply {
            id = entity.id
            userType = entity.userType
            expiryDate = entity.expiryDate
            isEnabled = entity.isEnabled
            username = entity.username
        }
    }
}
