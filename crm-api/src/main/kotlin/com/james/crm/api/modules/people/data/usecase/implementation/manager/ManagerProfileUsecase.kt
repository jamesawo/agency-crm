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
        val optionalAgent = repository.findById(managerId)
        return optionalAgent.map {
            it.profile = ProfileDto.toEntity(profileDto)
            val agent = repository.save(it)
            ResponseEntity.ok(ProfileDto.toTrimmedRequest(agent.profile))
        }.orElse(ResponseEntity.notFound().build())
    }
}