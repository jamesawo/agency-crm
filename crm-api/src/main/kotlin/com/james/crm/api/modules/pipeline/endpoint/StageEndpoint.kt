/*
 * @Author: james.aworo
 * @Date: 11/15/23
 *
 * @Project: agent-crm
 */

package com.james.crm.api.modules.pipeline.endpoint

import com.james.crm.api.core.common.ApiResponse
import com.james.crm.api.core.constant.Route
import com.james.crm.api.modules.pipeline.data.dto.StageDto
import com.james.crm.api.modules.pipeline.data.usecase.contract.stage.IAddStagesUsecase
import com.james.crm.api.modules.pipeline.data.usecase.contract.stage.IGetAllStagesUsecase
import com.james.crm.api.modules.pipeline.data.usecase.contract.stage.IGetStageUsecase
import com.james.crm.api.modules.pipeline.data.usecase.contract.stage.IUpdateStageUsecase
import jakarta.validation.Valid
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("${Route.API_VERSION}/stages")
class StageEndpoint(
    private val addStageUsecase: IAddStagesUsecase,
    private val getAllStageUsecase: IGetAllStagesUsecase,
    private val getStageUsecase: IGetStageUsecase,
    private val updateStageUsecase: IUpdateStageUsecase
) {
    @PostMapping("/pipeline/{pipelineId}")
    fun addStageToPipeline(
        @PathVariable pipelineId: String,
        @RequestBody stageDto: StageDto
    ): ResponseEntity<ApiResponse<StageDto>> {
        return addStageUsecase.execute(Pair(pipelineId, stageDto))
    }

    @GetMapping("/pipeline/{pipelineId}")
    fun getAllStageInPipeline(
        @PathVariable pipelineId: String
    ): ResponseEntity<ApiResponse<List<StageDto>>> {
        return getAllStageUsecase.execute(pipelineId)
    }

    @GetMapping("/{stageId}")
    fun getOneStageById(
        @PathVariable stageId: String
    ): ResponseEntity<ApiResponse<StageDto>> {
        return getStageUsecase.execute(stageId)
    }

    @PutMapping("/{stageId}")
    fun updateOneStage(
        @PathVariable stageId: String,
        @Valid @RequestBody stageDto: StageDto
    ): ResponseEntity<ApiResponse<Boolean>> {
        return updateStageUsecase.execute(Pair(stageId, stageDto))
    }
}