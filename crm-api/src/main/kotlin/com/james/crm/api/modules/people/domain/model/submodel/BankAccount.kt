/*
 * @Author: james.aworo
 * @Date: 11/6/23
 *
 * @Project: agent-crm
 */

package com.james.crm.api.modules.people.domain.model.submodel

import com.james.crm.api.core.constant.TableConstant
import com.james.crm.api.core.model.Base
import jakarta.persistence.Entity
import jakarta.persistence.Table

@Entity
@Table(name = TableConstant.BANK_ACC_TABLE)
class BankAccount(
    var accountName: String = "",
    var accountNumber: String = "",
    var bankName: String = "",
) : Base()