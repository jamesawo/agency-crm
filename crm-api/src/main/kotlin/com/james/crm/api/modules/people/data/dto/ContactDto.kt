package com.james.crm.api.modules.people.data.dto

import com.james.crm.api.core.model.Mapper
import com.james.crm.api.modules.people.domain.model.submodel.Contact

class ContactDto(val id: String?) : Mapper<ContactDto, Contact> {
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
        TODO("Not yet implemented")
    }
}
