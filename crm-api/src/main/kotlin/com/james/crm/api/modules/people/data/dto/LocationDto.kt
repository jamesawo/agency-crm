package com.james.crm.api.modules.people.data.dto

import com.james.crm.api.core.model.Mapper
import com.james.crm.api.modules.people.domain.model.submodel.Location

class LocationDto(val id: String? = null): Mapper<LocationDto, Location> {

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
        TODO("Not yet implemented")
    }

}
