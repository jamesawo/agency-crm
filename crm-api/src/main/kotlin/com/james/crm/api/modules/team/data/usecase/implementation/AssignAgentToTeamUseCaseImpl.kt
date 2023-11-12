/*
 * @Author: james.aworo
 * @Date: 11/11/23
 *
 * @Project: agent-crm
 */

package com.james.crm.api.modules.team.data.usecase.implementation

import com.james.crm.api.core.annotation.Usecase
import com.james.crm.api.core.common.ApiResponse
import com.james.crm.api.core.util.Util.Companion.notFoundMessageList
import com.james.crm.api.core.util.Util.Companion.toError
import com.james.crm.api.core.util.Util.Companion.toSuccess
import com.james.crm.api.modules.people.domain.repository.AgentDataRepository
import com.james.crm.api.modules.team.data.repository.TeamDataRepository
import com.james.crm.api.modules.team.data.usecase.contract.IAssignAgentToTeamUseCase
import org.springframework.http.HttpStatus.NOT_FOUND
import org.springframework.http.HttpStatus.OK
import org.springframework.http.ResponseEntity


@Usecase
class AssignAgentToTeamUseCaseImpl(
    private val teamRepository: TeamDataRepository,
    private val agentRepository: AgentDataRepository
) : IAssignAgentToTeamUseCase {

    override fun execute(input: Pair<String, String>): ResponseEntity<ApiResponse<Boolean>> {
        return teamRepository.findById(input.second).flatMap { team ->
            agentRepository.findById(input.first).map { agent ->
                agent.team = team
                agentRepository.save(agent)
                toSuccess(OK, true)
            }
        }.orElse(toError(NOT_FOUND, notFoundMessageList("team")))
    }
}
