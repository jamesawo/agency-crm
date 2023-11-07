/*
 * @Author: james.aworo
 * @Date: 11/1/23
 *
 * @Project: agent-crm
 */

package com.james.crm.api.modules.people.domain.model.shared

import com.james.crm.api.core.model.Base
import jakarta.persistence.Entity

@Entity
class Location : Base() {
    var longitude: String = ""
    var latitude: String = ""
    var name: String? = null
    var street: String? = null
    var type: String? = null
    var timezone: String? = null
}