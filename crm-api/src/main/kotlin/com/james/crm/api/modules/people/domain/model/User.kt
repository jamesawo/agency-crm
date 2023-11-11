/*
 * @Author: james.aworo
 * @Date: 10/30/23
 *
 * @Project: agent-crm
 */

package com.james.crm.api.modules.people.domain.model

import com.james.crm.api.core.constant.DatabaseTable.Companion.USER
import com.james.crm.api.core.model.Base
import com.james.crm.api.modules.people.domain.enums.UserTypeEnum
import jakarta.persistence.Entity
import jakarta.persistence.PrePersist
import jakarta.persistence.Table
import java.time.LocalDate

@Entity
@Table(name = USER)
class User() : Base(id = null) {
    var username: String = ""
    var password: String = ""
    var isEnabled: Boolean = true
    var expiryDate: LocalDate = LocalDate.now().plusDays(30)
    var userType: UserTypeEnum = UserTypeEnum.USER

    constructor(
        id: String? = null,
        username: String = "",
        password: String = "",
        isEnabled: Boolean = true,
        expiryDate: LocalDate = LocalDate.now().plusDays(30),
        userType: UserTypeEnum = UserTypeEnum.USER,
    ) : this() {
        this.id = id
        this.username = username
        this.password = password
        this.isEnabled = isEnabled
        this.expiryDate = expiryDate
        this.userType = userType
    }

    @PrePersist
    fun beforeSave() {
        println("{ User }: Hash password before saving")
    }
}