/*
 * @Author: james.aworo
 * @Date: 11/17/23
 *
 * @Project: agent-crm
 */

package com.james.crm.api.modules.task.data.dto

import com.james.crm.api.modules.task.domain.enums.CommissionType

data class TaskCommissionDto(
    var taskId: String?,
    var commission: Double = 0.0,
    var commissionType: CommissionType
) {
    constructor() : this(taskId = null, commission = 0.0, commissionType = CommissionType.PERCENTAGE_RATE)
}