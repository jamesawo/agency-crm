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
import com.james.crm.api.modules.pipeline.domain.enums.StageAction
import com.james.crm.api.modules.pipeline.domain.enums.StageReviewType
import com.james.crm.api.modules.pipeline.domain.enums.StageStatus

data class StageDto(var id: String? = null) {
    var title: String = ""
    var action: StageAction = StageAction.FILE_UPLOAD
    var reviewType: StageReviewType = StageReviewType.AUTO
    var status: StageStatus = StageStatus.CLOSE
    var hierarchy: Int = 0
    var pipeline: Pipeline = Pipeline()
    var stageValue: String = ""

    constructor() : this(id = null)

    constructor(
        id: String?,
        title: String = "",
        action: StageAction = StageAction.FILE_UPLOAD,
        reviewType: StageReviewType = StageReviewType.AUTO,
        status: StageStatus = StageStatus.CLOSE,
        hierarchy: Int = 0,
        pipeline: Pipeline = Pipeline(),
    ) : this(id) {
        this.title = title
        this.action = action
        this.reviewType = reviewType
        this.status = status
        this.hierarchy = hierarchy
        this.pipeline = pipeline
    }

    companion object : Mapper<StageDto, Stage> {
        override fun toEntity(request: StageDto): Stage {
            return Stage(
                id = request.id,
                title = request.title,
                action = request.action,
                hierarchy = request.hierarchy,
                status = request.status,
                stageValue = request.stageValue
            )
        }

        override fun toRequest(entity: Stage): StageDto {
            return StageDto(
                id = entity.id,
                title = entity.title,
                action = entity.action,
                reviewType = entity.reviewType,
                status = entity.status,
                hierarchy = entity.hierarchy
            )
        }
    }
}