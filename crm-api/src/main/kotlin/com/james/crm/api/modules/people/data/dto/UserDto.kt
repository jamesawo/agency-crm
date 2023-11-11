package com.james.crm.api.modules.people.data.dto

import com.fasterxml.jackson.annotation.JsonInclude
import com.fasterxml.jackson.annotation.JsonProperty
import com.james.crm.api.core.common.Mapper
import com.james.crm.api.modules.people.domain.enums.UserTypeEnum
import com.james.crm.api.modules.people.domain.model.User
import jakarta.validation.constraints.NotEmpty
import java.time.LocalDate

@JsonInclude(JsonInclude.Include.NON_NULL)
class UserDto(var id: String?) {
    @NotEmpty
    var username: String = ""

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @NotEmpty
    var password: String = ""

    var isEnabled: Boolean = true
    var expiryDate: LocalDate = LocalDate.now().plusDays(365)
    var userType: UserTypeEnum = UserTypeEnum.AGENT

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
            //todo:: implement security
            return User(
                id = request.id,
                userType = request.userType,
                expiryDate = request.expiryDate,
                isEnabled = request.isEnabled,
                username = request.username,
                password = request.password,
            )
        }
    }

}
