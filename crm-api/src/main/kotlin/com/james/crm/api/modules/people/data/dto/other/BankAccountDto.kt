package com.james.crm.api.modules.people.data.dto.other

data class BankAccountDto(
    val id: String? = null,
    var accountName: String = "",
    var accountNumber: String = "",
    var bankName: String = "",
)
