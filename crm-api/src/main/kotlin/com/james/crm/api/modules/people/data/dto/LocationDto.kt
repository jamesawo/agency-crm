package com.james.crm.api.modules.people.data.dto

import com.fasterxml.jackson.annotation.JsonInclude
import com.james.crm.api.core.model.Mapper
import com.james.crm.api.modules.people.domain.model.submodel.Location

@JsonInclude(JsonInclude.Include.NON_NULL)
class LocationDto(var id: String? = null) : Mapper<LocationDto, Location> {

    var longitude: String = ""
    var latitude: String = ""
    var title: String = ""
    var type: String = ""
    var timezone: String = ""

    override fun toEntity(): Location {
        val location = Location()
        location.longitude = longitude
        location.latitude = latitude
        location.title = title
        location.type = type
        location.timezone = timezone
        return location
    }

    override fun toRequest(entity: Location): LocationDto {
        return this.apply {
            id = entity.id
            longitude = entity.longitude
            latitude = entity.latitude
            title = entity.title
            type = entity.type
            timezone = entity.timezone
        }
    }

}
