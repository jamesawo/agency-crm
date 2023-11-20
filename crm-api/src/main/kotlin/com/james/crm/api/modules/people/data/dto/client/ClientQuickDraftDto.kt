package com.james.crm.api.modules.people.data.dto.client

import com.fasterxml.jackson.annotation.JsonInclude
import com.james.crm.api.core.common.Mapper
import com.james.crm.api.modules.people.domain.model.Client

@JsonInclude(JsonInclude.Include.NON_NULL)
class ClientQuickDraftDto(val id: String? = null) {
    var firstName: String = ""
    var lastName: String = ""
    var businessName: String = ""
    var email: String = ""
    var phone: String = ""
    var address: String? = null
    var industry: String? = null

    constructor(
        id: String?,
        firstName: String,
        lastName: String,
        businessName: String,
        email: String,
        phone: String,
        address: String?,
        industry: String?
    ) : this(id) {
        this.firstName = firstName
        this.lastName = lastName
        this.businessName = businessName
        this.email = email
        this.phone = phone
        this.address = address
        this.industry = industry
    }

    companion object : Mapper<ClientQuickDraftDto, Client> {
        override fun toEntity(request: ClientQuickDraftDto): Client {
            return Client(
                id = request.id,
                firstName = request.firstName,
                lastName = request.lastName,
                businessName = request.businessName,
                email = request.email,
                phone = request.phone,
                address = request.address ?: "",
                industry = request.industry ?: "",
            )
        }

        override fun toRequest(entity: Client): ClientQuickDraftDto {
            return ClientQuickDraftDto(
                id = entity.id,
                firstName = entity.firstName,
                lastName = entity.lastName,
                businessName = entity.businessName,
                email = entity.email,
                phone = entity.phone,
                address = entity.address,
                industry = entity.industry,
            )
        }
    }
}
