/*
 * @Author: james.aworo
 * @Date: 11/30/23
 *
 * @Project: agent-crm
 */

package com.james.crm.api.core.common

import org.springframework.data.domain.PageRequest
import org.springframework.data.domain.Sort

data class PagePayload(
    var page: Int,
    var size: Int,
    var sort: Sort.Direction,
) {
    
    fun toPageRequest(property: String? = null): PageRequest {
        return PageRequest.of(page - 1, size, Sort.by(sort, property))
    }
}