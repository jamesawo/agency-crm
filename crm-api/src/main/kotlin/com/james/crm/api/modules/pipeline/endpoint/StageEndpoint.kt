/*
 * @Author: james.aworo
 * @Date: 11/15/23
 *
 * @Project: agent-crm
 */

package com.james.crm.api.modules.pipeline.endpoint

import com.james.crm.api.core.constant.Route
import com.james.crm.api.modules.pipeline.data.usecase.contract.stage.IAddStagesUsecase
import com.james.crm.api.modules.pipeline.data.usecase.contract.stage.IGetAllStagesUsecase
import com.james.crm.api.modules.pipeline.data.usecase.contract.stage.IGetStageUsecase
import com.james.crm.api.modules.pipeline.data.usecase.contract.stage.IUpdateStageUsecase
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("${Route.API_VERSION}/stages")
class StageEndpoint(
    private val addStageUsecase: IAddStagesUsecase,
    private val getAllStageUsecase: IGetAllStagesUsecase,
    private val getStageUsecase: IGetStageUsecase,
    private val updateStageUsecase: IUpdateStageUsecase
)