/*
 * @Author: james.aworo
 * @Date: 11/11/23
 *
 * @Project: agent-crm
 */

package com.james.crm.api.modules.team.data.usecase.contract

import com.james.crm.api.core.common.Empty
import com.james.crm.api.core.common.Usecase
import com.james.crm.api.modules.people.data.dto.LocationDto

interface IGetAllTeamLocationUsecase : Usecase<Empty, List<LocationDto>>