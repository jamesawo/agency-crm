package com.james.crm.api.modules.people.data.dto

import com.fasterxml.jackson.annotation.JsonInclude
import com.james.crm.api.core.model.Mapper
import com.james.crm.api.modules.people.domain.model.submodel.BankAccount
import com.james.crm.api.modules.people.domain.model.submodel.Profile

@JsonInclude(JsonInclude.Include.NON_NULL)
data class ProfileDto(var id: String? = null) {
    var lastname: String = ""
    var firstName: String = ""
    var otherName: String = ""
    var dateOfBirth: String = ""
    var department: String = ""
    var bankAccount: BankAccountDto? = null
    var virtualBankAccount: BankAccountDto? = null

    constructor(
        id: String? = null,
        lastname: String = "",
        firstName: String = "",
        otherName: String = "",
        dateOfBirth: String = "",
        department: String = "",
        bankAccount: BankAccountDto? = null,
        virtualAccount: BankAccountDto? = null
    ) : this(id) {
        this.lastname = lastname
        this.firstName = firstName
        this.otherName = otherName
        this.dateOfBirth = dateOfBirth
        this.department = department
        this.bankAccount = bankAccount
        this.virtualBankAccount = virtualAccount
    }

    companion object : Mapper<ProfileDto, Profile> {
        override fun toEntity(request: ProfileDto): Profile {
            val profile = Profile()
            profile.lastname = request.lastname
            profile.lastname = request.lastname
            profile.firstName = request.firstName
            profile.otherName = request.otherName
            profile.dateOfBirth = request.dateOfBirth
            profile.department = request.department
            return profile
        }

        override fun toRequest(entity: Profile): ProfileDto {
            val account: BankAccount = entity.bankAccount ?: BankAccount()
            val vAccount: BankAccount = entity.virtualBankAccount ?: BankAccount()
            return ProfileDto(
                id = entity.id,
                lastname = entity.lastname,
                firstName = entity.firstName,
                otherName = entity.otherName,
                dateOfBirth = entity.dateOfBirth,
                department = entity.department,
                bankAccount = BankAccountDto(
                    id = account.id,
                    accountName = account.accountName,
                    accountNumber = account.accountNumber,
                    bankName = account.bankName
                ),
                virtualAccount = BankAccountDto(
                    id = vAccount.id,
                    accountName = vAccount.accountName,
                    accountNumber = vAccount.accountNumber,
                    bankName = vAccount.bankName
                ),
            )
        }

        override fun toTrimmedRequest(entity: Profile): ProfileDto {
            return toRequest(entity).apply {
                bankAccount = null
                virtualBankAccount = null
            }
        }
    }


}
