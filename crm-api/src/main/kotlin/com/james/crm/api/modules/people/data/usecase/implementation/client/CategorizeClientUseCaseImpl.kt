/*
 * @Author: james.aworo
 * @Date: 11/18/23
 *
 * @Project: agent-crm
 */

package com.james.crm.api.modules.people.data.usecase.implementation.client

import com.james.crm.api.core.annotation.Usecase
import com.james.crm.api.core.common.ApiResponse
import com.james.crm.api.core.common.CatchableError
import com.james.crm.api.core.util.Util.Companion.errorResponse
import com.james.crm.api.core.util.Util.Companion.notFoundMessageAsList
import com.james.crm.api.core.util.Util.Companion.successResponse
import com.james.crm.api.modules.people.data.dto.client.SearchCriteriaDto
import com.james.crm.api.modules.people.data.usecase.contract.client.ICategorizeClientUsecase
import com.james.crm.api.modules.people.domain.repository.ClientDataRepository
import org.springframework.data.domain.PageRequest
import org.springframework.http.HttpStatus.*
import org.springframework.http.ResponseEntity

/*
 * CategorizeClientUseCaseImpl
 *
 * Description:
 * This class implements the ICategorizeClientsUseCase interface, defining the use case for categorizing clients
 * within the application. Categorization involves associating clients with specific tags or categories, aiding
 * in the organization and classification of clients based on various criteria.
 *
 * Method Signature:
 * interface ICategorizeClientsUseCase : Usecase<CategorizationDto, List<ClientDto>>
 *
 * Method Details:
 * - Input: CategorizationDto - Contains information for categorization (clientId, tags).
 * - Output: List<ClientDto> - Updated list of clients after the categorization process.
 *
 * Use Case Scenarios:
 * 1. Agents can use this to categorize clients based on specific criteria.
 * 2. Categorization provides a structured way to organize and manage client data.
 *
 * Example Scenario:
 * val categorizationDto = CategorizationDto(clientId = "12345", tags = listOf("Potential Buyer", "Investor"))
 * val result = categorizeClientsUseCase.execute(categorizationDto)
 * // Result contains the list of clients with updated categorizations.
 *
 * Implementation Notes:
 * - Updates the client entity in the repository with assigned tags.
 * - Returns a list of clients with updated categorizations.
 *

 * Additional Considerations:
 * - Provides a structured way to handle client categorization, enhancing maintainability and flexibility in managing client data.
 */
@Usecase
class CategorizeClientUseCaseImpl(
    private val clientRepository: ClientDataRepository
) : ICategorizeClientUsecase {

    override fun execute(input: Pair<PageRequest, SearchCriteriaDto>): ResponseEntity<ApiResponse<Boolean>> {
        return try {
            clientRepository.findById(input.clientId).map { client ->
                client.tags = input.tags.toList()
                clientRepository.save(client)
                successResponse(OK, true)
            }.orElse(errorResponse(NOT_FOUND, notFoundMessageAsList("client")))
        } catch (ex: Exception) {
            errorResponse(INTERNAL_SERVER_ERROR, CatchableError(INTERNAL_SERVER_ERROR, ex))
        }
    }
}
