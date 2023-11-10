/*
 * @Author: james.aworo
 * @Date: 11/8/23
 *
 * @Project: agent-crm
 */

package com.james.crm.api.modules.people.data.usecase.implementation.manager

import com.james.crm.api.core.annotation.Usecase
import com.james.crm.api.modules.people.data.dto.UserDto
import com.james.crm.api.modules.people.data.usecase.contract.manager.IManagerUserUsecase
import com.james.crm.api.modules.people.domain.repository.ManagerDataRepository
import org.springframework.http.ResponseEntity

@Usecase
class ManagerUserUsecase(
    private val managerRepo: ManagerDataRepository
) : IManagerUserUsecase {

    override fun getUser(managerId: String): ResponseEntity<UserDto> {
        return managerRepo.findById(managerId).map {
            ResponseEntity.ok().body(UserDto.toTrimmedRequest(it.user))
        }.orElse(ResponseEntity.notFound().build())
    }

    override fun updateUser(managerId: String, userDto: UserDto): ResponseEntity<UserDto> {
        return managerRepo.findById(managerId).map {
            it.user = UserDto.toEntity(userDto.apply { id = it.user.id; password = it.user.password })
            ResponseEntity.ok(UserDto.toTrimmedRequest(managerRepo.save(it).user))
        }.orElse(ResponseEntity.notFound().build())
    }
}