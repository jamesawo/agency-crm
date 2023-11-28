/*
 * @Author: james.aworo
 * @Date: 11/13/23
 *
 * @Project: agent-crm
 */

package com.james.crm.api.modules.pipeline.domain

import com.james.crm.api.core.common.Base
import com.james.crm.api.core.constant.DatabaseTable.Companion.STAGE
import com.james.crm.api.modules.pipeline.domain.enums.StageAction
import com.james.crm.api.modules.pipeline.domain.enums.StageReviewType
import com.james.crm.api.modules.pipeline.domain.enums.StageStatus
import jakarta.persistence.Entity
import jakarta.persistence.FetchType
import jakarta.persistence.ManyToOne
import jakarta.persistence.Table

@Entity
@Table(name = STAGE)
class Stage(id: String?) : Base(id) {
    var title: String = ""

    var action: StageAction = StageAction.FILE_UPLOAD

    var reviewType: StageReviewType = StageReviewType.AUTO

    var status: StageStatus = StageStatus.CLOSE

    var hierarchy: Int = 0

    @ManyToOne(fetch = FetchType.LAZY)
    var pipeline: Pipeline = Pipeline()

    var stageValue: String = ""

    constructor() : this(id = null)
    constructor(
        id: String?,
        title: String,
        action: StageAction,
        hierarchy: Int,
        status: StageStatus,
        stageValue: String
    ) : this(id) {
        this.id = id
        this.title = title
        this.action = action
        this.reviewType = StageReviewType.AUTO
        this.status = status
        this.hierarchy = hierarchy
        this.stageValue = value
    }

}