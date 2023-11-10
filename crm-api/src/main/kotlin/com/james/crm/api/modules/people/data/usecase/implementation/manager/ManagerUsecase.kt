/*
 * @Author: james.aworo
 * @Date: 11/10/23
 *
 * @Project: agent-crm
 */

package com.james.crm.api.modules.people.data.usecase.implementation.manager

import com.james.crm.api.core.annotation.Usecase
import com.james.crm.api.modules.people.data.dto.ManagerDto
import com.james.crm.api.modules.people.data.usecase.contract.manager.IManagerUsecase
import com.james.crm.api.modules.people.domain.model.Manager
import com.james.crm.api.modules.people.domain.repository.ManagerDataRepository
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import java.util.*

@Usecase
class ManagerUsecase(
    private val repository: ManagerDataRepository
) : IManagerUsecase {

    override fun create(manager: ManagerDto): ResponseEntity<ManagerDto> {
        val saved = repository.save(ManagerDto.toEntity(manager))
        return ResponseEntity.ok(ManagerDto.toTrimmedRequest(saved))
    }

    override fun find(managerId: String): ResponseEntity<ManagerDto?> {
        return this.findById(managerId).map { ResponseEntity.ok(ManagerDto.toRequest(it)) }
            .orElse(ResponseEntity.notFound().build())
    }

    override fun findById(managerId: String): Optional<Manager> = repository.findById(managerId)
    override fun remove(managerId: String): ResponseEntity<Boolean> {
        return try {
            return this.findById(managerId)
                .map { manager ->
                    repository.delete(manager)
                    ResponseEntity(true, HttpStatus.OK)
                }
                .orElse(ResponseEntity(false, HttpStatus.NOT_FOUND))
        } catch (e: Exception) {
            //log error
            ResponseEntity(false, HttpStatus.NOT_FOUND)
        }
    }


}