package com.james.crm.api.modules.people.data.dto

import com.fasterxml.jackson.annotation.JsonInclude
import com.james.crm.api.core.common.Mapper
import com.james.crm.api.modules.people.domain.model.submodel.Task

@JsonInclude(JsonInclude.Include.NON_NULL)
class TaskDto {

    companion object : Mapper<TaskDto, Task> {
        override fun toEntity(request: TaskDto): Task {
            TODO("Not yet implemented")
        }

        override fun toRequest(entity: Task): TaskDto {
            TODO("Not yet implemented")
        }
    }
}
