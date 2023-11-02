/*
 * @Author: james.aworo
 * @Date: 11/1/23
 *
 * @Project: agent-crm
 */

package com.james.crm.api.modules.people.domain.model

import com.james.crm.api.modules.people.domain.model.shared.ManagerContact
import com.james.crm.api.modules.people.domain.model.shared.ManagerProfile

class Manager: User() {
    lateinit var profile: ManagerProfile
    lateinit var contact: ManagerContact
    lateinit var user: User
}