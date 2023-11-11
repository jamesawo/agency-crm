/*
 * @Author: james.aworo
 * @Date: 11/11/23
 *
 * @Project: agent-crm
 */

package com.james.crm.api.modules.team.data.usecase.implementation

import com.james.crm.api.core.annotation.Usecase
import com.james.crm.api.modules.people.data.dto.LocationDto
import com.james.crm.api.modules.team.data.repository.TeamDataRepository
import com.james.crm.api.modules.team.data.usecase.contract.IGetTeamLocationUsecase
import org.springframework.http.ResponseEntity

@Usecase
class GetTeamLocationUseCaseImpl(
    private val teamRepository: TeamDataRepository
) : IGetTeamLocationUsecase {

    /*override fun getTeamLocations(): ResponseEntity<List<LocationDto>> {
        *//*  val teams = teamRepository.findAll()
          val teamLocations = teams.map { team ->
              team.location?.let { LocationDto.toRequest(it) } ?: LocationDto()
          }
          return ResponseEntity.ok(teamLocations)*//*
        TODO()
    }*/
    override fun execute(input: Nothing): ResponseEntity<LocationDto> {
        TODO("Not yet implemented")
    }
}
