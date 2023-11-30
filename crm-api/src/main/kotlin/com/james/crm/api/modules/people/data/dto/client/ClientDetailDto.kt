/*
 * @Author: james.aworo
 * @Date: 11/18/23
 *
 * @Project: agent-crm
 */

package com.james.crm.api.modules.people.data.dto.client

import com.james.crm.api.core.common.Mapper
import com.james.crm.api.modules.people.domain.enums.ClientStatus
import com.james.crm.api.modules.people.domain.enums.ContactMethod
import com.james.crm.api.modules.people.domain.model.Client
import java.time.LocalDate

data class ClientDetailDto(var id: String? = "") {
    var firstName: String = ""
    var lastName: String = ""
    var businessName: String = ""
    var email: String = ""
    var phone: String = ""
    var address: String = ""
    var industry: String = ""
    var notes: String = ""
    var status: ClientStatus? = null
    var revenue: Double? = 0.00
    var lastInteractionDate: LocalDate? = null
    var preferredContactMethod: ContactMethod? = null
    var tags: Set<String> = emptySet()

    constructor(
        id: String?,
        firstName: String,
        lastName: String,
        businessName: String,
        email: String,
        phone: String,
        address: String?,
        industry: String?,
        notes: String?,
        status: ClientStatus?,
        revenue: Double?,
        lastInteractionDate: LocalDate?,
        preferredContactMethod: ContactMethod?,
        tags: Set<String>
    ) : this() {
        this.id = id
        this.firstName = firstName
        this.lastName = lastName
        this.businessName = businessName
        this.email = email
        this.phone = phone
        this.address = address ?: ""
        this.industry = industry ?: ""
        this.notes = notes ?: ""
        this.status = status
        this.revenue = revenue
        this.lastInteractionDate = lastInteractionDate
        this.preferredContactMethod = preferredContactMethod
        this.tags = tags
    }

    companion object : Mapper<ClientDetailDto, Client> {
        override fun toEntity(request: ClientDetailDto): Client {
            return Client(
                id = request.id,
                firstName = request.firstName,
                lastName = request.lastName,
                businessName = request.businessName,
                email = request.email,
                phone = request.phone,
                address = request.address,
                industry = request.industry,
                notes = request.notes,
                status = request.status,
                revenue = request.revenue,
                lastInteractionDate = request.lastInteractionDate,
                preferredContactMethod = request.preferredContactMethod,
                tags = request.tags.toList()
            )
        }

        override fun toRequest(entity: Client): ClientDetailDto {
            return ClientDetailDto(
                id = entity.id,
                firstName = entity.firstName,
                lastName = entity.lastName,
                businessName = entity.businessName,
                email = entity.email,
                phone = entity.phone,
                address = entity.address,
                industry = entity.industry,
                notes = entity.notes,
                status = entity.status,
                revenue = entity.revenue,
                lastInteractionDate = entity.lastInteractionDate,
                preferredContactMethod = entity.preferredContactMethod,
                tags = entity.tags.toSet()
            )
        }

        fun updateDetails(updateDto: ClientDetailDto, client: Client): Client {
            client.firstName = updateDto.firstName
            client.lastName = updateDto.lastName
            client.businessName = updateDto.businessName
            client.email = updateDto.email
            client.phone = updateDto.phone
            client.address = updateDto.address
            client.industry = updateDto.industry
            client.notes = updateDto.notes
            client.status = updateDto.status
            client.revenue = updateDto.revenue
            client.lastInteractionDate = updateDto.lastInteractionDate
            client.preferredContactMethod = updateDto.preferredContactMethod
            client.tags = updateDto.tags.toList()
            return client
        }

    }

}
