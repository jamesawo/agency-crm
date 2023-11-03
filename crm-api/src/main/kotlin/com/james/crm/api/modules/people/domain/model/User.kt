/*
 * @Author: james.aworo
 * @Date: 10/30/23
 *
 * @Project: agent-crm
 */

package com.james.crm.api.modules.people.domain.model

import com.james.crm.api.core.constant.TableConstant.Companion.USER_TABLE
import com.james.crm.api.core.model.Base
import com.james.crm.api.modules.people.domain.enums.UserTypeEnum
import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.Table
import java.time.LocalDate

@Entity
@Table(name = USER_TABLE)
open class User(@Column val username: String,
    @Column var password: String,
    @Column var isEnabled: Boolean,
    @Column var expiryDate: LocalDate,
    @Column var userType: UserTypeEnum
) : Base() {
    constructor() : this(
        username = "",
        password = "",
        isEnabled = true,
        expiryDate = LocalDate.now().plusDays(30),
        userType = UserTypeEnum.AGENT)
}