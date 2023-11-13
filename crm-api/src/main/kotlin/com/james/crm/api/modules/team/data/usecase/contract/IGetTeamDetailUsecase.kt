/*
 * @Author: james.aworo
 * @Date: 11/13/23
 *
 * @Project: agent-crm
 */

package com.james.crm.api.modules.team.data.usecase.contract.temp

import com.james.crm.api.core.common.Usecase
import com.james.crm.api.modules.team.data.dto.TeamDetailDto

interface IGetTeamDetailUsecase : Usecase<String, TeamDetailDto>