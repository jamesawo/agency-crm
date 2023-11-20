/*
 * @Author: james.aworo
 * @Date: 11/1/23
 *
 * @Project: agent-crm
 */

package com.james.crm.api.modules.people.domain.model

import com.james.crm.api.core.common.Base
import com.james.crm.api.core.constant.DatabaseTable.Companion.CLIENT
import com.james.crm.api.modules.people.domain.enums.ClientStatus
import com.james.crm.api.modules.people.domain.enums.ContactMethod
import com.james.crm.api.modules.task.domain.Task
import jakarta.persistence.*
import java.time.LocalDate

@Entity
@Table(name = CLIENT)
class Client(id: String? = null) : Base(id) {
    var firstName: String = ""
    var lastName: String = ""
    var businessName: String = ""
    var email: String = ""
    var phone: String = ""
    var address: String? = null
    var industry: String? = null
    var notes: String? = null
    var status: ClientStatus? = null
    var revenue: Double? = null
    var lastInteractionDate: LocalDate? = null
    var preferredContactMethod: ContactMethod? = null

    @OneToOne
    var task: Task? = null

    @ElementCollection
    var tags: List<String> = emptyList()

    @ManyToOne(fetch = FetchType.LAZY)
    var agent: Agent = Agent()

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
        task: Task?,
        tags: List<String>,
        agent: Agent
    ) : this(id) {
        this.firstName = firstName
        this.lastName = lastName
        this.businessName = businessName
        this.email = email
        this.phone = phone
        this.address = address
        this.industry = industry
        this.notes = notes
        this.status = status
        this.revenue = revenue
        this.lastInteractionDate = lastInteractionDate
        this.preferredContactMethod = preferredContactMethod
        this.task = task
        this.tags = tags
        this.agent = agent
    }

    constructor(
        id: String? = null,
        firstName: String,
        lastName: String,
        businessName: String,
        email: String,
        phone: String,
        address: String,
        industry: String,
        notes: String,
        status: ClientStatus?,
        revenue: Double?,
        lastInteractionDate: LocalDate?,
        preferredContactMethod: ContactMethod?,
        tags: List<String>
    ) : this(id) {
        this.id = id
        this.firstName = firstName
        this.lastName = lastName
        this.businessName = businessName
        this.email = email
        this.phone = phone
        this.address = address
        this.industry = industry
        this.notes = notes
        this.status = status
        this.revenue = revenue
        this.lastInteractionDate = lastInteractionDate
        this.preferredContactMethod = preferredContactMethod
        this.tags = tags
    }

    constructor(
        id: String?,
        firstName: String,
        lastName: String,
        businessName: String,
        email: String,
        phone: String,
        address: String,
        industry: String,
    ) : this() {
        this.id = id
        this.firstName = firstName
        this.lastName = lastName
        this.businessName = businessName
        this.email = email
        this.phone = phone
        this.address = address
        this.industry = industry
    }
}
