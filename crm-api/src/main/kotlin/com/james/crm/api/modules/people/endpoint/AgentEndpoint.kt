/*
 * @Author: james.aworo
 * @Date: 11/1/23
 *
 * @Project: agent-crm
 */

package com.james.crm.api.modules.people.endpoint

import com.james.crm.api.core.constant.Route
import com.james.crm.api.modules.people.data.dto.AgentDto
import com.james.crm.api.modules.people.data.usecase.AgentUsecaseImpl
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("${Route.BASE}/agents/")
class AgentEndpoint(
    private val agentUsecaseImpl: AgentUsecaseImpl
) {

    @PostMapping()
    fun create(@RequestBody agentDto: AgentDto): ResponseEntity<AgentDto> {

        val result = agentUsecaseImpl.create(agentDto)

        return result;
    }
}