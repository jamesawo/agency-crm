package com.james.crm.api.modules.people.data.dto

import com.fasterxml.jackson.annotation.JsonInclude
import com.james.crm.api.core.model.Mapper
import com.james.crm.api.modules.people.domain.model.submodel.Contact

@JsonInclude(JsonInclude.Include.NON_NULL)
class ContactDto(var id: String?) : Mapper<ContactDto, Contact> {
    var phone: String = ""
    var email: String = ""
    var secondaryPhone: String = ""
    var secondaryEmail: String = ""
    var address: String = ""

    constructor() : this(id = null)

    override fun toEntity(): Contact {
        val contact = Contact()
        contact.phone = phone
        contact.email = email
        contact.secondaryPhone = secondaryPhone
        contact.secondaryEmail = secondaryEmail
        contact.address = address

        return contact
    }

    override fun toRequest(entity: Contact): ContactDto {
        return this.apply {
            id = entity.id
            phone = entity.phone
            email = entity.email
            secondaryPhone = entity.secondaryPhone
            secondaryEmail = entity.secondaryEmail
            address = entity.address
        }
    }
}
