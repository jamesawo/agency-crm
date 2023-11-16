/*
 * @Author: james.aworo
 * @Date: 11/16/23
 *
 * @Project: agent-crm
 */

package com.james.crm.api.modules.task.data.usecase.contract

import com.james.crm.api.core.common.Usecase
import com.james.crm.api.modules.task.data.dto.AssignPipelineToTaskInput
import com.james.crm.api.modules.task.data.dto.TaskDto

interface IAssignPipelineToTaskUsecase : Usecase<AssignPipelineToTaskInput, TaskDto>
