/*
 * @Author: james.aworo
 * @Date: 11/6/23
 *
 * @Project: agent-crm
 */

package com.james.crm.api.modules.people.domain.model.submodel

import com.james.crm.api.core.constant.DatabaseTable.Companion.BANK_ACCOUNT
import com.james.crm.api.core.model.Base
import jakarta.persistence.Entity
import jakarta.persistence.Table

@Entity
@Table(name = BANK_ACCOUNT)
class BankAccount(
    id: String?,
    var accountName: String = "",
    var accountNumber: String = "",
    var bankName: String = "",
) : Base(id) {
    constructor() : this(id = null)
}