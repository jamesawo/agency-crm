/*
 * @Author: james.aworo
 * @Date: 11/1/23
 *
 * @Project: agent-crm
 */

package com.james.crm.api.modules.people.domain.model.submodel

import com.james.crm.api.core.common.Base
import com.james.crm.api.core.constant.DatabaseTable.Companion.TASK
import jakarta.persistence.Entity
import jakarta.persistence.Table

@Entity
@Table(name = TASK)
class Task : Base() {
    var title: String = ""
}