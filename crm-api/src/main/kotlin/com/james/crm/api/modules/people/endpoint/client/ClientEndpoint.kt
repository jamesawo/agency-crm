/*
 * @Author: james.aworo
 * @Date: 11/18/23
 *
 * @Project: agent-crm
 */

package com.james.crm.api.modules.people.endpoint.client

import com.james.crm.api.core.common.ApiResponse
import com.james.crm.api.core.common.ResourceId
import com.james.crm.api.core.constant.Route
import com.james.crm.api.modules.people.data.dto.agent.AgentDto
import com.james.crm.api.modules.people.data.dto.client.*
import com.james.crm.api.modules.people.data.usecase.contract.client.*
import com.james.crm.api.modules.people.domain.enums.ClientStatus
import com.james.crm.api.modules.pipeline.data.dto.StageDto
import com.james.crm.api.modules.task.data.dto.TaskDto
import jakarta.validation.Valid
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("${Route.API_VERSION}/clients")
class ClientEndpoint(
    private val createClientUsecase: ICreateClientUsecase,
    private val updateClientInformationUsecase: IUpdateClientInformationUsecase,
    private val viewClientDetailsUsecase: IViewClientDetailsUsecase,
    private val associateClientWithAgentUsecase: IAssociateClientWithAgentUsecase,
    private val searchAndFilterClientsUsecase: ISearchAndFilterClientsUsecase,
    private val trackClientInteractionsUsecase: ITrackClientInteractionsUsecase,
    private val categorizeClientsUsecase: ICategorizeClientUsecase,
    private val setClientStatusUsecase: ISetClientStatusUsecase,
    private val retrieveClientsAssociatedWithAgentUsecase: IRetrieveClientsAssociatedWithAgentUsecase,
    private val viewAssignedStagesForClientUsecase: IViewAssignedStagesForClientUsecase,
    private val completeStageForClientUsecase: ICompleteStageForClientUsecase,
    private val viewTaskDetailsForClientUsecase: IViewTaskDetailsForClientUsecase
) {

    @PostMapping("{agentId}")
    fun createClient(
        @PathVariable agentId: String,
        @Valid @RequestBody input: ClientDto,
    ): ResponseEntity<ApiResponse<ResourceId>> {
        return createClientUsecase.execute(Pair(agentId, input))
    }

    @PutMapping("{clientId}/update-information")
    fun updateClientInformation(
        @PathVariable(required = true) clientId: String,
        @RequestBody input: ClientDetailDto
    ): ResponseEntity<ApiResponse<Boolean>> {
        return updateClientInformationUsecase.execute(input)
    }

    @GetMapping("{clientId}")
    fun viewClientDetails(
        @PathVariable(required = true) clientId: String
    ): ResponseEntity<ApiResponse<ClientDetailDto>> {
        return viewClientDetailsUsecase.execute(clientId)
    }

    /*
    * In the case of Agent dismissal or unavailability,
    * A manager can transfer a client to another agent for business continuity
    * */
    @PutMapping("{clientId}/associate-with-agent/{agentId}")
    fun associateClientWithAgent(
        @PathVariable(required = true) clientId: String,
        @PathVariable(required = true) agentId: String
    ): ResponseEntity<ApiResponse<Boolean>> {
        return associateClientWithAgentUsecase.execute(Pair(clientId, agentId))
    }

    @PostMapping("/search-and-filter")
    fun searchAndFilterClients(
        @Valid @RequestBody input: SearchCriteriaDto
    ): ResponseEntity<ApiResponse<List<ClientDto>>> {
        return searchAndFilterClientsUsecase.execute(input)
    }

    @PostMapping("{clientId}/track-interaction")
    fun trackClientInteraction(
        @PathVariable(required = true) clientId: String
    ): ResponseEntity<ApiResponse<InteractionDto>> {
        return trackClientInteractionsUsecase.execute(clientId)
    }

    @PostMapping("{clientId}/categorize")
    fun categorizeClient(
        @PathVariable(required = true) clientId: String,
        @Valid @RequestBody input: CategorizationDto
    ): ResponseEntity<ApiResponse<Boolean>> {
        return categorizeClientsUsecase.execute(input)
    }

    @PutMapping("{clientId}/set-status")
    fun setClientStatus(
        @PathVariable(required = true) clientId: String,
        @Valid @RequestBody input: ClientStatus
    ): ResponseEntity<ApiResponse<Boolean>> {
        return setClientStatusUsecase.execute(Pair(clientId, input))
    }

    @GetMapping("agent/{agentId}")
    fun retrieveClientsAssociatedWithAgent(
        @PathVariable(required = true) agentId: String
    ): ResponseEntity<ApiResponse<List<ClientDto>>> {
        return retrieveClientsAssociatedWithAgentUsecase.execute(agentId)
    }

    @GetMapping("{clientId}/assigned-stages")
    fun viewAssignedStagesForClient(
        @PathVariable(required = true) clientId: String
    ): ResponseEntity<ApiResponse<List<StageDto>>> {
        return viewAssignedStagesForClientUsecase.execute(clientId)
    }

    @PostMapping("{clientId}/complete-stage")
    fun completeStageForClient(
        @PathVariable(required = true) clientId: String,
        @Valid @RequestBody input: StageCompletionDto
    ): ResponseEntity<ApiResponse<Boolean>> {
        return completeStageForClientUsecase.execute(input)
    }

    @GetMapping("{clientId}/task-details")
    fun viewTaskDetailsForClient(
        @PathVariable(required = true) clientId: String
    ): ResponseEntity<ApiResponse<TaskDto?>> {
        return viewTaskDetailsForClientUsecase.execute(clientId)
    }


    @GetMapping("{clientId}/interactions")
    fun getClientInteractions(
        @PathVariable(required = true) clientId: String
    ): ResponseEntity<ApiResponse<List<InteractionDto>>> {
        TODO()
    }

    @GetMapping("{clientId}/categories")
    fun getClientCategories(
        @PathVariable(required = true) clientId: String
    ): ResponseEntity<ApiResponse<List<CategorizationDto>>> {
        TODO()
    }

    @GetMapping("{clientId}/status-history")
    fun getClientStatusHistory(
        @PathVariable(required = true) clientId: String
    ): ResponseEntity<ApiResponse<List<ClientStatus>>> {
        TODO()
    }

    @GetMapping("{clientId}/associated-agent")
    fun getAssociatedAgent(
        @PathVariable(required = true) clientId: String
    ): ResponseEntity<ApiResponse<AgentDto>> {
        TODO()
    }


}
