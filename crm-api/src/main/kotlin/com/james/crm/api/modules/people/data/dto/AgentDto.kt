/*
 * @Author: james.aworo
 * @Date: 11/7/23
 *
 * @Project: agent-crm
 */

package com.james.crm.api.modules.people.data.dto

class AgentDto {
    var id: String? = null
    val isActive: Boolean? = null
    var profile: ProfileDto = ProfileDto()
    var contact: ContactDto = ContactDto()
    var emergencyContact: ContactDto = ContactDto()
    var user: UserDto = UserDto()
    var clients: MutableList<ClientDto> = mutableListOf()
    var resources: MutableList<ResourceDto> = mutableListOf()
    var task: TaskDto = TaskDto()
    var team: TeamDto = TeamDto()
    var location: LocationDto = LocationDto()
    var manager: ManagerDto = ManagerDto()
}