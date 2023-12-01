/*
 * @Author: james.aworo
 * @Date: 11/13/23
 *
 * @Project: agent-crm
 */

package com.james.crm.api.modules.pipeline.data.dto

import com.james.crm.api.core.common.Mapper
import com.james.crm.api.modules.pipeline.domain.Pipeline
import jakarta.validation.constraints.NotBlank
import jakarta.validation.constraints.NotNull
import java.time.LocalDate

data class PipelineDto(
    var id: String? = null,

    @NotBlank
    var title: String = "",

    @NotNull
    var hierarchy: Int = 0
) {

    var stages: MutableList<StageDto> = mutableListOf()

    var createdAt: LocalDate? = null

    var isActive: Boolean? = null

    var createdBy: String? = null


    constructor() : this(id = null)

    constructor(
        id: String?,
        title: String,
        hierarchy: Int,
        stages: MutableList<StageDto>
    ) : this(id = null) {
        this.id = id
        this.title = title
        this.hierarchy = hierarchy
        this.stages = stages
    }

    companion object : Mapper<PipelineDto, Pipeline> {
        override fun toEntity(request: PipelineDto): Pipeline {
            val stages = if (request.stages.isNotEmpty()) request.stages
                .map { StageDto.toEntity(it) }
                .toMutableList() else mutableListOf()

            return Pipeline(
                id = request.id,
                title = request.title,
                hierarchy = request.hierarchy,
                stages = stages
            )
        }

        override fun toRequest(entity: Pipeline): PipelineDto {
            val pipeline = PipelineDto(
                id = entity.id,
                title = entity.title,
                hierarchy = entity.hierarchy,
                stages = entity.stages.map { StageDto.toRequest(it) }.toMutableList()
            )
            pipeline.createdAt = entity.createdAt.toLocalDate()
            pipeline.isActive = entity.isActive
            pipeline.createdBy = entity.createdBy
            return pipeline
        }

        override fun toTrimRequest(entity: Pipeline): PipelineDto {
            val pipeline = PipelineDto(
                id = entity.id,
                title = entity.title,
                hierarchy = entity.hierarchy,
            )
            pipeline.createdAt = entity.createdAt.toLocalDate()
            pipeline.isActive = entity.isActive
            pipeline.createdBy = entity.createdBy
            return pipeline
        }
    }
}