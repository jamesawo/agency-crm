/*
 * @Author: james.aworo
 * @Date: 11/1/23
 *
 * @Project: agent-crm
 */

package com.james.crm.api.modules.people.domain.model.submodel

import com.james.crm.api.core.constant.DatabaseTable.Companion.TEAM
import com.james.crm.api.core.model.Base
import jakarta.persistence.Entity
import jakarta.persistence.Table

@Entity
@Table(name = TEAM)
class Team: Base() {
    var title: String = ""
}