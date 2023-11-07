/*
 * @Author: james.aworo
 * @Date: 11/1/23
 *
 * @Project: agent-crm
 */

package com.james.crm.api.modules.people.domain.model.submodel

import com.james.crm.api.core.constant.DatabaseTable.Companion.CONTACT
import com.james.crm.api.core.model.Base
import jakarta.persistence.Entity
import jakarta.persistence.Table


@Entity
@Table(name = CONTACT)
class Contact(
    var phone: String = "",
    var email: String = "",
    var secondaryPhone: String = "",
    var secondaryEmail: String = "",
    var address: String = "",
) : Base()



