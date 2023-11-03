/*
 * @Author: james.aworo
 * @Date: 11/1/23
 *
 * @Project: agent-crm
 */

package com.james.crm.api.modules.people.domain.model.shared

import com.james.crm.api.core.model.Base
import jakarta.persistence.Column
import jakarta.persistence.Entity

@Entity
open class Profile : Base() {
    @Column()
    var lastname: String = ""

    @Column()
    var firstName: String = ""

    @Column()
    var otherName: String = ""

    @Column()
    var dateOfBirth: String = ""

    @Column()
    var department: String = ""
}