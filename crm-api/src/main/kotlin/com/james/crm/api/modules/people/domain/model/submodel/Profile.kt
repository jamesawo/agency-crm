/*
 * @Author: james.aworo
 * @Date: 11/1/23
 *
 * @Project: agent-crm
 */

package com.james.crm.api.modules.people.domain.model.shared

import com.james.crm.api.core.model.Base

open class Profile(
    var lastname: String = "",
    var firstName: String = "",
    var otherName: String = "",
    var dateOfBirth: String = "",
    var department: String = "",
) : Base()
