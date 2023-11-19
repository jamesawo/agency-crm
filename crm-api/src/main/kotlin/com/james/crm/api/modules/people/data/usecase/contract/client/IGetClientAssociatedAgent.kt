/*
 * @Author: james.aworo
 * @Date: 11/19/23
 *
 * @Project: agent-crm
 */

package com.james.crm.api.modules.people.data.usecase.contract.client

import com.james.crm.api.core.common.Usecase
import com.james.crm.api.modules.people.data.dto.agent.AgentDto

interface IGetClientAssociatedAgent : Usecase<String, AgentDto>