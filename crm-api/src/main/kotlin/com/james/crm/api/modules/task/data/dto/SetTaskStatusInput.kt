/*
 * @Author: james.aworo
 * @Date: 11/16/23
 *
 * @Project: agent-crm
 */

package com.james.crm.api.modules.task.data.dto

import com.james.crm.api.modules.task.domain.enums.TaskStatus

data class SetTaskStatusInput(
    val taskId: String,
    val status: TaskStatus
)