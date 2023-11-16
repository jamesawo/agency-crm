/*
 * @Author: james.aworo
 * @Date: 11/16/23
 *
 * @Project: agent-crm
 */

package com.james.crm.api.modules.task.domain

import com.james.crm.api.core.common.Base
import com.james.crm.api.core.constant.DatabaseTable
import com.james.crm.api.modules.pipeline.domain.Pipeline
import com.james.crm.api.modules.task.domain.enums.CommissionType
import com.james.crm.api.modules.task.domain.enums.TaskStatus
import jakarta.persistence.*
import java.time.LocalDate

@Entity
@Table(name = DatabaseTable.TASK)
class Task(id: String? = null) : Base(id) {

    var title: String = ""

    var startDate: LocalDate? = null

    var endDate: LocalDate? = null

    var budget: Double = 0.00

    @Enumerated(EnumType.STRING)
    var commissionType: CommissionType? = null

    var commissionRate: Double = 0.00

    @Enumerated(EnumType.STRING)
    var status: TaskStatus? = null

    @ManyToOne(cascade = [CascadeType.ALL], fetch = FetchType.LAZY)
    var pipeline: Pipeline? = null

    constructor(
        title: String,
        startDate: LocalDate?,
        endDate: LocalDate?,
        budget: Double,
        commissionType: CommissionType?,
        commissionRate: Double,
        status: TaskStatus?,
        pipeline: Pipeline?
    ) : this() {
        this.title = title
        this.startDate = startDate
        this.endDate = endDate
        this.budget = budget
        this.commissionType = commissionType
        this.commissionRate = commissionRate
        this.status = status
        this.pipeline = pipeline
    }
}
