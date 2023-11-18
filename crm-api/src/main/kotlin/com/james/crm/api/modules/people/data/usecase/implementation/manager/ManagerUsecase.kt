/*
 * @Author: james.aworo
 * @Date: 11/10/23
 *
 * @Project: agent-crm
 */

package com.james.crm.api.modules.people.data.usecase.implementation.manager

import com.james.crm.api.core.annotation.Usecase
import com.james.crm.api.core.common.ApiResponse
import com.james.crm.api.core.common.CatchableError
import com.james.crm.api.core.util.Util.Companion.errorResponse
import com.james.crm.api.core.util.Util.Companion.notFoundMessageAsList
import com.james.crm.api.core.util.Util.Companion.successResponse
import com.james.crm.api.modules.people.data.dto.manager.ManagerDto
import com.james.crm.api.modules.people.data.usecase.contract.manager.IManagerUsecase
import com.james.crm.api.modules.people.domain.model.Manager
import com.james.crm.api.modules.people.domain.repository.ManagerDataRepository
import org.springframework.http.HttpStatus.*
import org.springframework.http.ResponseEntity
import java.util.*

@Usecase
class ManagerUsecase(
    private val repository: ManagerDataRepository
) : IManagerUsecase {

    override fun create(manager: ManagerDto): ResponseEntity<ApiResponse<ManagerDto>> {
        return try {
            val saved = repository.save(ManagerDto.toEntity(manager))
            successResponse(CREATED, ManagerDto.toTrimRequest(saved))
        } catch (ex: Exception) {
            errorResponse(INTERNAL_SERVER_ERROR, CatchableError(INTERNAL_SERVER_ERROR, listOf(ex.localizedMessage), ex))
        }
    }

    override fun find(managerId: String): ResponseEntity<ApiResponse<ManagerDto>> {
        return this.findById(managerId).map { manager ->
            successResponse(OK, ManagerDto.toTrimRequest(manager))
        }.orElse(errorResponse(NOT_FOUND, notFoundMessageAsList("manager")))
    }

    override fun findById(managerId: String): Optional<Manager> {
        return repository.findById(managerId)
    }

    override fun remove(managerId: String): ResponseEntity<ApiResponse<Boolean>> {
        return try {
            this.findById(managerId).map { manager ->
                repository.delete(manager)
                successResponse(OK, true)
            }.orElse(errorResponse(NOT_FOUND, notFoundMessageAsList("manager")))
        } catch (ex: Exception) {
            errorResponse(INTERNAL_SERVER_ERROR, CatchableError(INTERNAL_SERVER_ERROR, listOf(ex.localizedMessage), ex))
        }
    }

}