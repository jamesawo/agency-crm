package com.james.crm.api.modules.people.data.dto

import com.fasterxml.jackson.annotation.JsonInclude
import com.james.crm.api.core.model.Mapper
import com.james.crm.api.modules.people.domain.model.submodel.Contact
import jakarta.validation.constraints.NotBlank

@JsonInclude(JsonInclude.Include.NON_NULL)
open class ContactDto(var id: String?) {
    @NotBlank(message = "phone is required")
    var phone: String = ""

    @NotBlank(message = "email cannot be empty")
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
            return Contact(
                id = request.id,
                phone = request.phone,
                email = request.email,
                secondaryPhone = request.secondaryPhone,
                secondaryEmail = request.secondaryEmail,
                address = request.address,
            )
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

    override fun toString(): String {
        return "id: ${this.id} \n" +
                "phone: ${this.phone} \n" +
                "email: ${this.email} \n" +
                "secondaryPhone: ${this.secondaryPhone} \n" +
                "secondaryEmail: ${this.secondaryEmail} \n" +
                "address: ${this.address}  "
    }

}
