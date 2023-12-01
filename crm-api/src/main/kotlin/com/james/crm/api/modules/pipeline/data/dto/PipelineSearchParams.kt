/*
 * @Author: james.aworo
 * @Date: 11/30/23
 *
 * @Project: agent-crm
 */

package com.james.crm.api.modules.pipeline.data.dto

import com.james.crm.api.core.common.DateRange

data class PipelineSearchParams(
    var title: String? = null,
    var dateRange: DateRange?,
    var createdBy: String?,
    var isActive: Boolean?,
    var numOfStages: Int?,
)