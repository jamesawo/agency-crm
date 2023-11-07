/*
 * @Author: james.aworo
 * @Date: 11/1/23
 *
 * @Project: agent-crm
 */

package com.james.crm.api.modules.people.domain.model.submodel

import com.james.crm.api.core.constant.TableConstant
import com.james.crm.api.core.model.Base
import com.james.crm.api.modules.people.domain.model.User
import jakarta.persistence.Entity
import jakarta.persistence.FetchType
import jakarta.persistence.ManyToOne
import jakarta.persistence.Table

@Entity
@Table(name = TableConstant.RESOURCE_TABLE)
class Resource: Base() {
    var title: String = ""
    var type: String = ""
    var url: String = ""

    @ManyToOne(fetch = FetchType.LAZY)
    var owner: User = User()

}