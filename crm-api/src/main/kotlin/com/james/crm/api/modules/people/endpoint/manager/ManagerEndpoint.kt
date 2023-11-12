/*
 * @Author: james.aworo
 * @Date: 11/1/23
 *
 * @Project: agent-crm
 */

package com.james.crm.api.modules.people.endpoint.manager

import com.james.crm.api.core.common.ApiResponse
import com.james.crm.api.core.constant.Route.Companion.API_VERSION
import com.james.crm.api.modules.people.data.dto.ManagerDto
import com.james.crm.api.modules.people.data.usecase.contract.manager.IManagerUsecase
import jakarta.validation.Valid
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*


@RestController
@RequestMapping("$API_VERSION/managers/")
class ManagerEndpoint(
    private val usecase: IManagerUsecase
) {

    @PostMapping()
    fun create(
        @Valid @RequestBody manager: ManagerDto
    ): ResponseEntity<ApiResponse<ManagerDto>> {
        return usecase.create(manager)
    }

    @GetMapping("{managerId}")
    fun get(@PathVariable managerId: String): ResponseEntity<ApiResponse<ManagerDto>> {
        return usecase.find(managerId)
    }

    @DeleteMapping("{managerId}")
    fun delete(@PathVariable managerId: String): ResponseEntity<ApiResponse<Boolean>> {
        return usecase.remove(managerId)
    }
}