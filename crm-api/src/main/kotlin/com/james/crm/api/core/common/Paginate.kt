/*
 * @Author: james.aworo
 * @Date: 11/13/23
 *
 * @Project: agent-crm
 */

package com.james.crm.api.core.common

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonInclude
import org.springframework.data.domain.Page
import org.springframework.data.domain.Sort

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
class Paginate<T>(
    var pageNumber: Int,
    var pageSize: Int,
    var totalPages: Int,
    var totalElements: Long,
    var sort: Sort? = null,
    var content: List<T>?,
) {

    companion object {
        fun <T> fromPage(page: Page<T>): Paginate<T> {
            return Paginate(
                pageNumber = page.pageable.pageNumber + 1,
                pageSize = page.pageable.pageSize,
                totalPages = page.totalPages,
                totalElements = page.totalElements,
                content = page.content,
                sort = page.sort
            )
        }
    }
}