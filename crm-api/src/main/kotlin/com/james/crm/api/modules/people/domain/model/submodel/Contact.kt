/*
 * @Author: james.aworo
 * @Date: 11/1/23
 *
 * @Project: agent-crm
 */

package com.james.crm.api.modules.people.domain.model.submodel

import com.james.crm.api.core.common.Base
import com.james.crm.api.core.constant.DatabaseTable.Companion.CONTACT
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
) : Base() {
    constructor(
        id: String? = null,
        phone: String = "",
        email: String = "",
        secondaryPhone: String = "",
        secondaryEmail: String = "",
        address: String = "",
    ) : this() {
        this.id = id
        this.phone = phone
        this.email = email
        this.secondaryPhone = secondaryPhone
        this.secondaryEmail = secondaryEmail
        this.address = address
    }
    
}



