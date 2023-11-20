/*
 * @Author: james.aworo
 * @Date: 11/18/23
 *
 * @Project: agent-crm
 */

package com.james.crm.api.modules.people.endpoint.client

import com.james.crm.api.core.common.ApiResponse
import com.james.crm.api.core.common.Paginate
import com.james.crm.api.core.common.ResourceId
import com.james.crm.api.core.constant.Route
import com.james.crm.api.modules.people.data.dto.agent.AgentDto
import com.james.crm.api.modules.people.data.dto.client.*
import com.james.crm.api.modules.people.data.usecase.contract.client.*
import com.james.crm.api.modules.people.domain.enums.ClientStatus
import com.james.crm.api.modules.pipeline.data.dto.StageDto
import com.james.crm.api.modules.task.data.dto.TaskDto
import jakarta.validation.Valid
import org.springframework.data.domain.PageRequest
import org.springframework.data.domain.Sort
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
    private val viewTaskDetailsForClientUsecase: IViewTaskDetailsForClientUsecase,
    private val clientQuickDraftUsecase: IClientQuickDraftUsecase,
    private val getClientCategoriesUsecaseImpl: IGetClientCategoriesUsecase,
    private val retrieveAgentFromClientUsecase: IRetrieveAgentAssociatedWithClientUsecase
) {

    @PostMapping("/{agentId}")
    fun createClient(
        @PathVariable agentId: String,
        @Valid @RequestBody clientDto: ClientDto,
    ): ResponseEntity<ApiResponse<ResourceId>> {
        return createClientUsecase.execute(Pair(agentId, clientDto))
    }

    @PostMapping("/quick-draft/{agentId}")
    fun quickDraftClient(
        @PathVariable agentId: String,
        @Valid @RequestBody input: ClientQuickDraftDto,
    ): ResponseEntity<ApiResponse<ResourceId>> {
        return clientQuickDraftUsecase.execute(Pair(agentId, input))
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
        @Valid @RequestBody searchInput: SearchCriteriaDto,
        @RequestParam(defaultValue = "1") page: Int,
        @RequestParam(defaultValue = "10") size: Int,
        @RequestParam(defaultValue = "ASC", required = false) sort: Sort.Direction
    ): ResponseEntity<ApiResponse<Paginate<ClientDto>>> {
        return searchAndFilterClientsUsecase.execute(
            Pair(
                PageRequest.of(page - 1, size, Sort.by(sort, "")),
                searchInput
            )
        )
    }


    @PostMapping("{clientId}/track-interaction")
    fun getClientInteraction(
        @PathVariable(required = true) clientId: String
    ): ResponseEntity<ApiResponse<InteractionDto>> {
        return trackClientInteractionsUsecase.execute(clientId)
    }

    @PostMapping("{clientId}/categorize")
    fun setClientCategory(
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
        @PathVariable(required = true) agentId: String,
        @RequestParam(defaultValue = "1") page: Int,
        @RequestParam(defaultValue = "10") size: Int,
        @RequestParam(defaultValue = "ASC", required = false) sort: Sort.Direction
    ): ResponseEntity<ApiResponse<Paginate<ClientDto>>> {
        return retrieveClientsAssociatedWithAgentUsecase.execute(
            Pair(
                agentId,
                PageRequest.of(page - 1, size, Sort.by(sort, "")),
            )
        )
    }

    @GetMapping("{clientId}/assigned-stages")
    fun viewAssignedStagesForClient(
        @PathVariable(required = true) clientId: String
    ): ResponseEntity<ApiResponse<List<StageDto>>> {
        return viewAssignedStagesForClientUsecase.execute(clientId)
    }

    @PostMapping("{clientId}/complete-stage/{stageId}")
    fun completeStageForClient(
        @PathVariable(required = true) clientId: String,
        @PathVariable(required = true) stageId: String,

        ): ResponseEntity<ApiResponse<Boolean>> {
        return completeStageForClientUsecase.execute(Pair(clientId, stageId))
    }

    @GetMapping("{clientId}/task-details")
    fun viewTaskDetailsForClient(
        @PathVariable(required = true) clientId: String
    ): ResponseEntity<ApiResponse<TaskDto?>> {
        return viewTaskDetailsForClientUsecase.execute(clientId)
    }


    @GetMapping("{clientId}/categories")
    fun getClientCategories(
        @PathVariable(required = true) clientId: String
    ): ResponseEntity<ApiResponse<CategorizationDto>> {
        return getClientCategoriesUsecaseImpl.execute(clientId)
    }


    @GetMapping("{clientId}/associated-agent")
    fun getAssociatedAgent(
        @PathVariable(required = true) clientId: String
    ): ResponseEntity<ApiResponse<AgentDto>> {
        return retrieveAgentFromClientUsecase.execute(clientId)
    }


}
