package com.james.crm.api.modules.task.data.dto

import com.james.crm.api.modules.task.domain.enums.TaskStatus
import java.time.LocalDate

data class TaskPerformanceDto(
    val taskId: String,
    val taskTitle: String,
    val status: TaskStatus,
    val startDate: LocalDate?,
    val endDate: LocalDate?,
    val completionPercentage: Double,
    val completionAmount: Double,
    val comments: List<String>
)

