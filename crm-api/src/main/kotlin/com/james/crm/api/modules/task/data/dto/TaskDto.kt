package com.james.crm.api.modules.task.data.dto

import com.fasterxml.jackson.annotation.JsonInclude
import com.james.crm.api.core.common.Mapper
import com.james.crm.api.modules.pipeline.domain.Pipeline
import com.james.crm.api.modules.task.domain.Task
import com.james.crm.api.modules.task.domain.enums.CommissionType
import com.james.crm.api.modules.task.domain.enums.TaskStatus
import java.time.LocalDate

@JsonInclude(JsonInclude.Include.NON_NULL)
class TaskDto(
    var id: String? = null,
    var title: String = "",
    var startDate: LocalDate? = null,
    var endDate: LocalDate? = null,
    var budget: Double = 0.00,
    var commissionType: CommissionType? = null,
    var commissionRate: Double = 0.00,
    var status: TaskStatus? = null,
    var pipelineId: String? = null
) {

    companion object : Mapper<TaskDto, Task> {
        override fun toEntity(request: TaskDto): Task {
            return Task(
                title = request.title,
                startDate = request.startDate,
                endDate = request.endDate,
                budget = request.budget,
                commissionType = request.commissionType,
                commissionRate = request.commissionRate,
                status = request.status,
                pipeline = if (request.pipelineId != null) Pipeline(id = request.pipelineId) else null
            )
        }

        override fun toRequest(entity: Task): TaskDto {
            return TaskDto(
                title = entity.title,
                startDate = entity.startDate,
                endDate = entity.endDate,
                budget = entity.budget,
                commissionType = entity.commissionType,
                commissionRate = entity.commissionRate,
                status = entity.status,
                pipelineId = entity.pipeline?.id
            )
        }

        fun setTaskParameter(task: Task, input: SetTaskParametersInput): Task {
            task.startDate = input.startDate
            task.endDate = input.endDate
            task.budget = input.budget
            task.commissionType = input.commissionType
            task.commissionRate = input.commissionRate
            return task
        }
    }
}

