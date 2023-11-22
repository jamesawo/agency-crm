/*
 * @Author: james.aworo
 * @Date: 11/21/23
 *
 * @Project: agent-crm
 */

package com.james.crm.api.modules.pipeline.data.usecase.contract.pipeline

import com.james.crm.api.core.common.Paginate
import com.james.crm.api.core.common.Usecase
import com.james.crm.api.modules.pipeline.data.dto.StageDto
import org.springframework.data.domain.Pageable

interface IGetAllStageInPipelineUsecase : Usecase<Pair<String, Pageable>, Paginate<StageDto>>