/*
 * @Author: james.aworo
 * @Date: 11/13/23
 *
 * @Project: agent-crm
 */

package com.james.crm.api.modules.pipeline.data.usecase.contract.stage

import com.james.crm.api.core.common.Usecase
import com.james.crm.api.modules.pipeline.data.dto.StageDto

interface IUpdateStageUsecase : Usecase<Pair<String, StageDto>, Boolean>