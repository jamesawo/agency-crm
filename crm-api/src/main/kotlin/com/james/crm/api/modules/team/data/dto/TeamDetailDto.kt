/*
 * @Author: james.aworo
 * @Date: 11/11/23
 *
 * @Project: agent-crm
 */

package com.james.crm.api.modules.team.data.dto

import jakarta.validation.constraints.Min
import jakarta.validation.constraints.NotBlank


data class TeamDetailDto(
    @NotBlank
    val title: String,

    val managerId: String?,

    @Min(0)
    val budget: Double = 0.00,
)