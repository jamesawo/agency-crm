package com.james.crm.api.modules.people.data.dto

import com.fasterxml.jackson.annotation.JsonInclude
import com.fasterxml.jackson.annotation.JsonProperty
import com.james.crm.api.core.model.Mapper
import com.james.crm.api.modules.people.domain.model.User
import com.james.crm.api.modules.people.domain.model.UserTypeEnum
import java.time.LocalDate

@JsonInclude(JsonInclude.Include.NON_NULL)
class UserDto(var id: String?) {
    var username: String = ""
    var isEnabled: Boolean = true
    var expiryDate: LocalDate = LocalDate.now().plusDays(365)
    var userType: UserTypeEnum = UserTypeEnum.AGENT

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    var password: String = ""

    constructor() : this(id = null)
    constructor(
        id: String? = null,
        username: String = "",
        isEnabled: Boolean = true,
        expiryDate: LocalDate = LocalDate.now().plusDays(365),
        userType: UserTypeEnum = UserTypeEnum.AGENT,
        password: String = "",
    ) : this(id) {
        this.id = id
        this.username = username
        this.isEnabled = isEnabled
        this.expiryDate = expiryDate
        this.userType = userType
        this.password = password
    }

    companion object : Mapper<UserDto, User> {
        override fun toRequest(entity: User): UserDto {
            return UserDto(
                id = entity.id,
                userType = entity.userType,
                expiryDate = entity.expiryDate,
                isEnabled = entity.isEnabled,
                username = entity.username
            )
        }

        override fun toEntity(request: UserDto): User {
            val user = User()
            user.userType = request.userType
            user.expiryDate = request.expiryDate
            user.isEnabled = request.isEnabled
            user.username = request.username
            //todo:: implement security
            user.password = request.password
            return user
        }
    }


}
