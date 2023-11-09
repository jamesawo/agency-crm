/*
 * @Author: james.aworo
 * @Date: 10/30/23
 *
 * @Project: agent-crm
 */

package com.james.crm.api.modules.people.domain.model

import com.james.crm.api.core.constant.DatabaseTable.Companion.USER
import com.james.crm.api.core.model.Base
import jakarta.persistence.Entity
import jakarta.persistence.PrePersist
import jakarta.persistence.Table
import java.time.LocalDate

enum class UserTypeEnum { AGENT, ADMIN }

@Entity
@Table(name = USER)
class User : Base() {
    var username: String = ""
    var password: String = ""
    var isEnabled: Boolean = true
    var expiryDate: LocalDate = LocalDate.now().plusDays(30)
    var userType: UserTypeEnum = UserTypeEnum.AGENT

    @PrePersist
    fun beforeSave() {
        println("{ User }: Hash password before saving")
    }
}