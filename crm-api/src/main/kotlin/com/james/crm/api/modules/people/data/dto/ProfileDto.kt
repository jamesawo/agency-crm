package com.james.crm.api.modules.people.data.dto

import com.james.crm.api.core.model.Mapper
import com.james.crm.api.modules.people.domain.model.submodel.Profile

data class ProfileDto(val id: String? = null) : Mapper<ProfileDto, Profile> {
    var lastname: String = ""
    var firstName: String = ""
    var otherName: String = ""
    var dateOfBirth: String = ""
    var department: String = ""
    var bankAccount: BankAccountDto? = null
    var virtualBankAccount: BankAccountDto? = null


    override fun toEntity(): Profile {
        val profile = Profile()
        profile.lastname = lastname
        profile.lastname = lastname
        profile.firstName = firstName
        profile.otherName = otherName
        profile.dateOfBirth = dateOfBirth
        profile.department = department
        return profile
    }

    override fun toRequest(entity: Profile): ProfileDto {
        TODO("Not yet implemented")
    }
}
