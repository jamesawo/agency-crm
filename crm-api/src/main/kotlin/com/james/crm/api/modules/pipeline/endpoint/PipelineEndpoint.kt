/*
 * @Author: james.aworo
 * @Date: 11/15/23
 *
 * @Project: agent-crm
 */

package com.james.crm.api.modules.pipeline.endpoint

import com.james.crm.api.core.constant.Route
import com.james.crm.api.modules.pipeline.data.usecase.contract.pipeline.ICreatePipelineUsecase
import com.james.crm.api.modules.pipeline.data.usecase.contract.pipeline.IGetAllPipelineUsecase
import com.james.crm.api.modules.pipeline.data.usecase.contract.pipeline.IGetPipelineUsecase
import com.james.crm.api.modules.pipeline.data.usecase.contract.pipeline.IUpdatePipelineUsecase
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("${Route.API_VERSION}/pipelines")
class PipelineEndpoint(
    private val createPipelineUsecase: ICreatePipelineUsecase,
    private val getAllPipelineUsecase: IGetAllPipelineUsecase,
    private val getPipelineUsecase: IGetPipelineUsecase,
    private val updatePipelineUsecase: IUpdatePipelineUsecase
    
)