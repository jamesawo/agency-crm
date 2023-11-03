/*
 * @Author: james.aworo
 * @Date: 11/1/23
 *
 * @Project: agent-crm
 */

package com.james.crm.api.modules.people.domain.model.shared

import com.james.crm.api.core.constant.TableConstant.Companion.CONTACT_TABLE
import com.james.crm.api.core.model.Base
import jakarta.persistence.Entity
import jakarta.persistence.Table

@Entity
@Table(name = CONTACT_TABLE)
open class Contact : Base() {
    var phone: String = ""
    var email: String = ""
    var secondaryPhone: String = ""
    var secondaryEmail: String = ""
    var address: String = ""
}



