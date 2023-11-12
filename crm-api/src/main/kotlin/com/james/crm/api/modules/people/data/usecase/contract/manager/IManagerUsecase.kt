/*
 * @Author: james.aworo
 * @Date: 11/3/23
 *
 * @Project: agent-crm
 */

package com.james.crm.api.modules.people.data.usecase.contract.manager

import com.james.crm.api.core.common.ApiResponse
import com.james.crm.api.modules.people.data.dto.ManagerDto
import com.james.crm.api.modules.people.domain.model.Manager
import org.springframework.http.ResponseEntity
import java.util.*

interface IManagerUsecase {
    fun create(manager: ManagerDto): ResponseEntity<ApiResponse<ManagerDto>>

    fun find(managerId: String): ResponseEntity<ApiResponse<ManagerDto>>

    fun findById(managerId: String): Optional<Manager>
    fun remove(managerId: String): ResponseEntity<ApiResponse<Boolean>>
}
