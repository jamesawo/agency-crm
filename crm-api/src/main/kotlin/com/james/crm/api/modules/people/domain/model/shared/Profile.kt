/*
 * @Author: james.aworo
 * @Date: 11/1/23
 *
 * @Project: agent-crm
 */

package com.james.crm.api.modules.people.domain.model.shared

import com.james.crm.api.configuration.core.model.Base
import jakarta.persistence.Entity

@Entity
open class Profile: Base() {
    var firstName: String = ""
    var lastname: String = ""
    var otherName: String = ""
    var dateOfBirth: String = ""
    var department: String = ""
}