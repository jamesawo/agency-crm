/*
 * @Author: james.aworo
 * @Date: 11/30/23
 *
 * @Project: agent-crm
 */

package com.james.crm.api.modules.pipeline.data.usecase.contract.pipeline

import com.james.crm.api.core.common.PagePayload
import com.james.crm.api.core.common.Paginate
import com.james.crm.api.core.common.Usecase
import com.james.crm.api.modules.pipeline.data.dto.PipelineDto
import com.james.crm.api.modules.pipeline.data.dto.PipelineSearchParams

interface ISearchPipelineUsecase : Usecase<Pair<PipelineSearchParams, PagePayload>, Paginate<PipelineDto>>