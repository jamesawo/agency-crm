/*
 * @Author: james.aworo
 * @Date: 11/3/23
 *
 * @Project: agent-crm
 */

package com.james.crm.api.modules.people.data.usecase.contract.agent

import com.james.crm.api.core.common.ApiResponse
import com.james.crm.api.core.common.ResourceId
import com.james.crm.api.modules.people.data.dto.AgentDto
import org.springframework.http.ResponseEntity

interface IAgentUsecase {
    fun create(agent: AgentDto): ResponseEntity<ApiResponse<ResourceId>>

    fun remove(id: String): ResponseEntity<ApiResponse<Boolean>>

}
