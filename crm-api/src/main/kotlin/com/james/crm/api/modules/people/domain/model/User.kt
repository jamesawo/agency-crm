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
import jakarta.persistence.Entity
import jakarta.persistence.Table
import java.time.LocalDate

@Entity
@Table(name = USER_TABLE)
class User : Base() {
    var username: String = ""
    var password: String = ""
    var isEnabled: Boolean = true
    var expiryDate: LocalDate = LocalDate.now().plusDays(30)
    var userType: UserTypeEnum = UserTypeEnum.AGENT
}