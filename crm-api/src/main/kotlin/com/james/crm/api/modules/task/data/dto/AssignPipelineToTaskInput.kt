/*
 * @Author: james.aworo
 * @Date: 11/16/23
 *
 * @Project: agent-crm
 */

package com.james.crm.api.modules.task.data.dto

data class AssignPipelineToTaskInput(
    val taskId: String,
    val pipelineId: String
)