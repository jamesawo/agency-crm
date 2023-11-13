/*
 * @Author: james.aworo
 * @Date: 11/13/23
 *
 * @Project: agent-crm
 */

package com.james.crm.api.modules.pipeline.data.dto

import com.james.crm.api.core.common.Mapper
import com.james.crm.api.modules.pipeline.domain.Pipeline
import com.james.crm.api.modules.pipeline.domain.Stage

data class PipelineDto(var id: String? = null) {
    var title: String = ""
    var stages: List<StageDto> = emptyList()

    constructor() : this(id = null)

    constructor(
        id: String?,
        title: String,
        stages: List<StageDto>
    ) : this(id = null) {
        this.id = id
        this.title = title
        this.stages = stages
    }

    companion object : Mapper<PipelineDto, Pipeline> {
        override fun toEntity(request: PipelineDto): Pipeline {
            return Pipeline(
                id = request.id,
                title = request.title,
                stages = request.stages.map { Stage(it.id) }
            )
        }

        override fun toRequest(entity: Pipeline): PipelineDto {
            TODO("Not yet implemented")
        }
    }
}