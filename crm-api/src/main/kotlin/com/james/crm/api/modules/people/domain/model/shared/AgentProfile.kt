/*
 * @Author: james.aworo
 * @Date: 11/1/23
 *
 * @Project: agent-crm
 */

package com.james.crm.api.modules.people.domain.model.shared

import com.james.crm.api.core.constant.TableConstant.Companion.AGENT_PROFILE
import jakarta.persistence.Entity
import jakarta.persistence.Table

@Entity
@Table(name = AGENT_PROFILE)
class AgentProfile : Profile() {}