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
    var stages: List<Stage> = emptyList()
    var hierarchy: Int = 0
    // todo add functionality to group pipeline together and remove then add hierarchy to the grouped pipeline
    

    constructor() : this(id = null)
    constructor(
        id: String?,
        title: String,
        hierarchy: Int
    ) : this(id = null) {
        this.id = id
        this.title = title
        this.stages = emptyList()
        this.hierarchy = hierarchy
    }

    constructor(
        id: String?,
        title: String,
        stages: List<Stage>
    ) : this(id = null) {
        this.id = id
        this.title = title
        this.stages = stages
    }

}