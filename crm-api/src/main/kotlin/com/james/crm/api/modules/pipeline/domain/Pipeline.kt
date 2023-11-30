/*
 * @Author: james.aworo
 * @Date: 11/13/23
 *
 * @Project: agent-crm
 */

package com.james.crm.api.modules.pipeline.domain

import com.james.crm.api.core.common.Base
import com.james.crm.api.core.constant.DatabaseTable.Companion.PIPELINE
import jakarta.persistence.*

@Entity
@Table(name = PIPELINE)
class Pipeline(id: String?) : Base(id) {
    var title: String = ""

    @OneToMany(mappedBy = "pipeline", cascade = [CascadeType.ALL], fetch = FetchType.LAZY)
    var stages: MutableList<Stage> = mutableListOf()
    var hierarchy: Int = 0

    constructor() : this(id = null)
    constructor(
        id: String?,
        title: String,
        hierarchy: Int
    ) : this(id = null) {
        this.id = id
        this.title = title
        this.stages = mutableListOf()
        this.hierarchy = hierarchy
    }

    constructor(
        id: String?,
        title: String,
        hierarchy: Int,
        stages: MutableList<Stage>
    ) : this(id = null) {
        this.id = id
        this.title = title
        this.stages = stages
        this.hierarchy = hierarchy
    }

}