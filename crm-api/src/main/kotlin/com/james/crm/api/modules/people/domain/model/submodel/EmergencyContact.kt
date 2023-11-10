/*
 * @Author: james.aworo
 * @Date: 11/1/23
 *
 * @Project: agent-crm
 */

package com.james.crm.api.modules.people.domain.model.submodel

import com.james.crm.api.core.constant.DatabaseTable.Companion.EMERGENCY_CONTACT
import com.james.crm.api.core.model.Base
import jakarta.persistence.Entity
import jakarta.persistence.Table


@Entity
@Table(name = EMERGENCY_CONTACT)
class EmergencyContact(
    var phone: String = "",
    var email: String = "",
    var homeAddress: String = "",
    var fullName: String = "",
    var workAddress: String = "",
    var relationship: String = "",
    var occupation: String = "",
    var identificationStatus: Boolean = false,
    var commitmentStatus: Boolean = false,
) : Base()



