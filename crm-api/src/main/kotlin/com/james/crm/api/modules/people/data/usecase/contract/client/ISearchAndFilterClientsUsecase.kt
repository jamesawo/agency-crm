/*
 * @Author: james.aworo
 * @Date: 11/18/23
 *
 * @Project: agent-crm
 */

package com.james.crm.api.modules.people.data.usecase.contract.client

import com.james.crm.api.core.common.Paginate
import com.james.crm.api.core.common.Usecase
import com.james.crm.api.modules.people.data.dto.client.ClientDto
import com.james.crm.api.modules.people.data.dto.client.SearchCriteriaDto
import org.springframework.data.domain.Pageable

interface ISearchAndFilterClientsUsecase : Usecase<Pair<Pageable, SearchCriteriaDto>, Paginate<ClientDto>>
