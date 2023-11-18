package com.james.crm.api.modules.people.data.dto.client

import com.fasterxml.jackson.annotation.JsonInclude
import com.james.crm.api.core.common.Mapper
import com.james.crm.api.modules.people.data.dto.agent.AgentDto
import com.james.crm.api.modules.people.domain.enums.ClientStatus
import com.james.crm.api.modules.people.domain.enums.ContactMethod
import com.james.crm.api.modules.people.domain.model.Agent
import com.james.crm.api.modules.people.domain.model.Client
import com.james.crm.api.modules.task.data.dto.TaskDto
import com.james.crm.api.modules.task.domain.Task
import java.time.LocalDate

@JsonInclude(JsonInclude.Include.NON_NULL)
class ClientDto(val id: String? = null) {
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
    var task: TaskDto? = null
    var tags: Set<String> = emptySet()
    var agent: AgentDto = AgentDto()

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
        this.task = task.let { TaskDto(it?.id) }
        this.tags = tags.toSet()
        this.agent = AgentDto(agent.id)
    }

    constructor(
        id: String?,
        firstName: String,
        lastName: String,
        businessName: String,
        email: String,
        phone: String,
        address: String?,
        industry: String?,
        status: ClientStatus?,
        revenue: Double?,
        tags: List<String>
    ) : this(id) {
        this.firstName = firstName
        this.lastName = lastName
        this.businessName = businessName
        this.email = email
        this.phone = phone
        this.address = address
        this.industry = industry
        this.status = status
        this.revenue = revenue
        this.tags = tags.toSet()
    }

    companion object : Mapper<ClientDto, Client> {
        override fun toEntity(request: ClientDto): Client {
            return Client(
                id = request.id,
                firstName = request.firstName,
                lastName = request.lastName,
                businessName = request.businessName,
                email = request.email,
                phone = request.phone,
                address = request.address,
                industry = request.industry,
                notes = request.notes,
                status = request.status,
                revenue = request.revenue,
                lastInteractionDate = request.lastInteractionDate,
                preferredContactMethod = request.preferredContactMethod,
                task = request.task?.let { Task(it.id) },
                tags = request.tags.toList(),
                agent = Agent(request.id)
            )
        }

        override fun toRequest(entity: Client): ClientDto {
            return ClientDto(
                id = entity.id,
                firstName = entity.firstName,
                lastName = entity.lastName,
                businessName = entity.businessName,
                email = entity.email,
                phone = entity.phone,
                address = entity.address,
                industry = entity.industry,
                notes = entity.notes,
                status = entity.status,
                revenue = entity.revenue,
                lastInteractionDate = entity.lastInteractionDate,
                preferredContactMethod = entity.preferredContactMethod,
                task = entity.task?.let { Task(it.id) },
                tags = entity.tags.toList(),
                agent = Agent(entity.id)
            )
        }

        override fun toTrimRequest(entity: Client): ClientDto {
            return ClientDto(
                id = entity.id,
                firstName = entity.firstName,
                lastName = entity.lastName,
                businessName = entity.businessName,
                email = entity.email,
                phone = entity.phone,
                address = entity.address,
                industry = entity.industry,
                status = entity.status,
                revenue = entity.revenue,
                tags = entity.tags.toList(),
            )
        }
    }
}
