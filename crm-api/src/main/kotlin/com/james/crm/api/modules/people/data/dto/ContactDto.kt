package com.james.crm.api.modules.people.data.dto

import com.fasterxml.jackson.annotation.JsonInclude
import com.james.crm.api.core.model.Mapper
import com.james.crm.api.modules.people.domain.model.submodel.Contact

@JsonInclude(JsonInclude.Include.NON_NULL)
open class ContactDto(var id: String?) {
    var phone: String = ""
    var email: String = ""
    var secondaryPhone: String = ""
    var secondaryEmail: String = ""
    var address: String = ""

    constructor(
        id: String? = null,
        phone: String = "",
        email: String = "",
        secondaryPhone: String = "",
        secondaryEmail: String = "",
        address: String = "",
    ) : this(id) {
        this.id = id
        this.phone = phone
        this.email = email
        this.secondaryPhone = secondaryPhone
        this.secondaryEmail = secondaryEmail
        this.address = address
    }

    constructor() : this(id = null)

    companion object : Mapper<ContactDto, Contact> {
        override fun toEntity(request: ContactDto): Contact {
            val contact = Contact()
            contact.phone = request.phone
            contact.email = request.email
            contact.secondaryPhone = request.secondaryPhone
            contact.secondaryEmail = request.secondaryEmail
            contact.address = request.address

            return contact
        }

        override fun toRequest(entity: Contact): ContactDto {
            return ContactDto(
                id = entity.id,
                phone = entity.phone,
                email = entity.email,
                secondaryPhone = entity.secondaryPhone,
                secondaryEmail = entity.secondaryEmail,
                address = entity.address
            )
        }
    }

}
