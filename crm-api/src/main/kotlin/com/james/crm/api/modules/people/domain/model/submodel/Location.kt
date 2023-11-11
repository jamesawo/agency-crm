/*
 * @Author: james.aworo
 * @Date: 11/1/23
 *
 * @Project: agent-crm
 */

package com.james.crm.api.modules.people.domain.model.submodel

import com.james.crm.api.core.constant.DatabaseTable.Companion.LOCATION
import com.james.crm.api.core.model.Base
import jakarta.persistence.Entity
import jakarta.persistence.Table

@Entity
@Table(name = LOCATION)
class Location(
    id: String? = null,
    var longitude: String = "",
    var latitude: String = "",
    var title: String = "",
    var type: String = "",
    var timezone: String = "",
) : Base(id)