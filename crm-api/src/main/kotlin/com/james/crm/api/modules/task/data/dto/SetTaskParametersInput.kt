/*
 * @Author: james.aworo
 * @Date: 11/16/23
 *
 * @Project: agent-crm
 */

package com.james.crm.api.modules.task.data.dto

import com.james.crm.api.modules.task.domain.enums.CommissionType
import java.time.LocalDate

data class SetTaskParametersInput(
    val taskId: String,
    val startDate: LocalDate?,
    val endDate: LocalDate?,
    val budget: Double,
    val commissionType: CommissionType?,
    val commissionRate: Double
)