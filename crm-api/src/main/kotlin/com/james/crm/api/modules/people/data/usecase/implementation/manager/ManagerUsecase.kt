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
import org.springframework.http.ResponseEntity
import java.util.*

@Usecase
class ManagerUsecase(
    private val repository: ManagerDataRepository
) : IManagerUsecase {

    override fun create(manager: ManagerDto): ResponseEntity<ManagerDto> {
        TODO("Not yet implemented")
    }

    override fun find(managerId: String): ResponseEntity<ManagerDto?> {
        TODO("Not yet implemented")
    }

    override fun update(manager: ManagerDto): ResponseEntity<ManagerDto> {
        TODO("Not yet implemented")
    }

    override fun findById(managerId: String): Optional<Manager> = repository.findById(managerId)


}