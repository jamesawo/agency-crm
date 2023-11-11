/*
 * @Author: james.aworo
 * @Date: 11/11/23
 *
 * @Project: agent-crm
 */

package com.james.crm.api.modules.team.data.usecase.contract

import com.james.crm.api.core.model.Usecase
import com.james.crm.api.modules.team.data.dto.TeamDetailDto
import com.james.crm.api.modules.team.data.dto.TeamDto


interface ICreateTeamUsecase : Usecase<TeamDetailDto, TeamDto>

