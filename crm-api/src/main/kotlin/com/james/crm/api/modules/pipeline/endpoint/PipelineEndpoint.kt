/*
 * @Author: james.aworo
 * @Date: 11/15/23
 *
 * @Project: agent-crm
 */

package com.james.crm.api.modules.pipeline.endpoint

import com.james.crm.api.core.common.ApiResponse
import com.james.crm.api.core.common.Paginate
import com.james.crm.api.core.constant.Route
import com.james.crm.api.modules.pipeline.data.dto.PipelineDto
import com.james.crm.api.modules.pipeline.data.usecase.contract.pipeline.ICreatePipelineUsecase
import com.james.crm.api.modules.pipeline.data.usecase.contract.pipeline.IGetAllPipelineUsecase
import com.james.crm.api.modules.pipeline.data.usecase.contract.pipeline.IGetPipelineUsecase
import com.james.crm.api.modules.pipeline.data.usecase.contract.pipeline.IUpdatePipelineUsecase
import jakarta.validation.Valid
import org.springframework.data.domain.PageRequest
import org.springframework.data.domain.Sort
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("${Route.API_VERSION}/pipelines")
class PipelineEndpoint(
    private val createPipelineUsecase: ICreatePipelineUsecase,
    private val getAllPipelineUsecase: IGetAllPipelineUsecase,
    private val getPipelineUsecase: IGetPipelineUsecase,
    private val updatePipelineUsecase: IUpdatePipelineUsecase

) {
    @PostMapping
    fun createPipeline(
        @Valid @RequestBody pipelineDto: PipelineDto
    ): ResponseEntity<ApiResponse<PipelineDto>> {
        return createPipelineUsecase.execute(pipelineDto)
    }

    @GetMapping("/all")
    fun getAllPipeline(
        @RequestParam(defaultValue = "1") page: Int,
        @RequestParam(defaultValue = "10") size: Int,
        @RequestParam(defaultValue = "ASC", required = false) sort: Sort.Direction
    ): ResponseEntity<ApiResponse<Paginate<PipelineDto>>> {
        return getAllPipelineUsecase.execute(
            PageRequest.of(
                page - 1, size,
                Sort.by(sort, "hierarchy")
            )
        )
    }

    @GetMapping("/{pipelineId}")
    fun getOnePipeline(@PathVariable pipelineId: String): ResponseEntity<ApiResponse<PipelineDto>> {
        return getPipelineUsecase.execute(pipelineId)
    }

    @PutMapping("{pipelineId}")
    fun updatePipeline(
        @PathVariable pipelineId: String,
        @Valid @RequestBody pipelineDto: PipelineDto
    ): ResponseEntity<ApiResponse<Boolean>> {
        return updatePipelineUsecase.execute(Pair(pipelineId, pipelineDto))
    }
}
