import com.james.crm.api.core.constant.Route
import com.james.crm.api.modules.people.data.dto.ContactDto
import com.james.crm.api.modules.people.data.usecase.contract.agent.IAgentContactUsecase
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("${Route.BASE}/agents/{agentId}/contact")
class AgentContactEndpoint(
    private val contactUsecase: IAgentContactUsecase
) {
    @GetMapping("/{id}/contact")
    fun getContact(@PathVariable id: String, @PathVariable agentId: String): ResponseEntity<ContactDto> {
        return contactUsecase.getContact(id)
    }

    @PutMapping("/{id}/contact")
    fun updateContact(
        @PathVariable id: String,
        @RequestBody contactDto: ContactDto,
        @PathVariable agentId: String
    ): ResponseEntity<ContactDto> {
        return contactUsecase.updateContact(id, contactDto)
    }

}