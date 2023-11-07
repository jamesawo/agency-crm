package com.james.crm.api.modules.people.data.dto

import com.james.crm.api.core.model.Mapper
import com.james.crm.api.modules.people.domain.enums.UserTypeEnum
import com.james.crm.api.modules.people.domain.model.User
import java.time.LocalDate

class UserDto(var id: String?): Mapper<UserDto, User> {
    var username: String = ""
    var password: String = ""
    var isEnabled: Boolean = true
    var expiryDate: LocalDate = LocalDate.now().plusDays(30)
    var userType: UserTypeEnum = UserTypeEnum.AGENT

    constructor(): this(id = null)

    override fun toEntity(): User {
        val user = User()
        user.userType = userType
        user.expiryDate = expiryDate;
        user.isEnabled = isEnabled
        user.username = username
        return user
    }

    override fun toRequest(entity: User): UserDto {
        TODO("Not yet implemented")
    }
}
