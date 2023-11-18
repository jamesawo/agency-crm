package com.james.crm.api.modules.task.data.dto

import java.time.LocalDate

data class ManageTaskTimelinesInput(
    val taskId: String,
    val startDate: LocalDate?,
    val endDate: LocalDate?
)
