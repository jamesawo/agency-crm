package com.james.crm.api.modules.people.data.dto

import com.fasterxml.jackson.annotation.JsonInclude
import com.james.crm.api.core.model.Mapper
import com.james.crm.api.modules.people.domain.model.submodel.EmergencyContact

@JsonInclude(JsonInclude.Include.NON_NULL)
class EmergencyContactDto(var id: String?) {
    var phone: String = ""
    var email: String = ""
    var homeAddress: String = ""
    var fullName: String = ""
    var workAddress: String = ""
    var relationship: String = ""
    var occupation: String = ""
    var identificationStatus: Boolean = false
    var commitmentStatus: Boolean = false

    constructor() : this(id = null)

    constructor(
        id: String?,
        phone: String,
        email: String,
        address: String,
        fullName: String,
        workAddress: String,
        relationship: String,
        occupation: String,
        identificationStatus: Boolean,
        commitmentStatus: Boolean
    ) : this(id) {
        this.phone = phone
        this.email = email
        this.homeAddress = address
        this.fullName = fullName
        this.workAddress = workAddress
        this.relationship = relationship
        this.occupation = occupation
        this.identificationStatus = identificationStatus
        this.commitmentStatus = commitmentStatus
    }


    companion object : Mapper<EmergencyContactDto, EmergencyContact> {
        override fun toEntity(request: EmergencyContactDto): EmergencyContact {
            val contact = EmergencyContact()
            contact.phone = request.phone
            contact.email = request.email
            contact.homeAddress = request.homeAddress
            contact.fullName = request.fullName
            contact.workAddress = request.workAddress
            contact.relationship = request.relationship
            contact.occupation = request.occupation
            contact.identificationStatus = request.identificationStatus
            contact.commitmentStatus = request.commitmentStatus
            return contact
        }

        override fun toRequest(entity: EmergencyContact): EmergencyContactDto {
            return EmergencyContactDto(
                id = entity.id,
                phone = entity.phone,
                email = entity.email,
                address = entity.homeAddress,
                fullName = entity.fullName,
                workAddress = entity.workAddress,
                relationship = entity.relationship,
                occupation = entity.occupation,
                identificationStatus = entity.identificationStatus,
                commitmentStatus = entity.commitmentStatus,
            )
        }
    }

}
