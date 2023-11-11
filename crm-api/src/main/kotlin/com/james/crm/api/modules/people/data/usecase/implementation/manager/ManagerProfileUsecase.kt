/*
 * @Author: james.aworo
 * @Date: 11/8/23
 *
 * @Project: agent-crm
 */

package com.james.crm.api.modules.people.data.usecase.implementation.manager

import com.james.crm.api.core.annotation.Usecase
import com.james.crm.api.modules.people.data.dto.ProfileDto
import com.james.crm.api.modules.people.data.usecase.contract.manager.IManagerProfileUsecase
import com.james.crm.api.modules.people.domain.repository.ManagerDataRepository
import org.springframework.http.ResponseEntity

@Usecase
class ManagerProfileUsecase(
    private val repository: ManagerDataRepository,
) : IManagerProfileUsecase {
    override fun getProfile(managerId: String): ResponseEntity<ProfileDto> {
        return repository.findById(managerId).map {
            ResponseEntity.ok(ProfileDto.toTrimmedRequest(it.profile))
        }.orElse(ResponseEntity.notFound().build())
    }

    override fun updateProfile(managerId: String, profileDto: ProfileDto): ResponseEntity<ProfileDto> {
        return repository.findById(managerId).map {
            it.profile = ProfileDto.toEntity(profileDto.apply { id = it.profile.id })
            ResponseEntity.ok(ProfileDto.toTrimmedRequest(repository.save(it).profile))
        }.orElse(ResponseEntity.notFound().build())
    }
}