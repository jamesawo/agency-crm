package com.james.crm.api.modules.people.data.dto

import com.fasterxml.jackson.annotation.JsonInclude
import com.james.crm.api.core.model.Mapper
import com.james.crm.api.modules.people.domain.model.submodel.Location

@JsonInclude(JsonInclude.Include.NON_NULL)
class LocationDto(var id: String? = null) {
    var longitude: String = ""
    var latitude: String = ""
    var title: String = ""
    var type: String = ""
    var timezone: String = ""

    constructor(
        id: String? = null,
        longitude: String = "",
        latitude: String = "",
        title: String = "",
        type: String = "",
        timezone: String = "",
    ) : this(id) {
        this.longitude = longitude
        this.latitude = latitude
        this.title = title
        this.type = type
        this.timezone = timezone
    }

    companion object : Mapper<LocationDto, Location> {
        override fun toRequest(entity: Location): LocationDto {
            return LocationDto(
                id = entity.id,
                longitude = entity.longitude,
                latitude = entity.latitude,
                title = entity.title,
                type = entity.type,
                timezone = entity.timezone
            )
        }

        override fun toEntity(request: LocationDto): Location {
            return Location(
                longitude = request.longitude,
                latitude = request.latitude,
                title = request.title,
                type = request.type,
                timezone = request.timezone,
            ).apply { id = request.id }
        }
    }


}
