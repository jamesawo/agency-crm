/*
 * @Author: james.aworo
 * @Date: 11/7/23
 *
 * @Project: agent-crm
 */

package com.james.crm.api.core.common

interface Mapper<R, E> {
    fun toEntity(request: R): E
    fun toRequest(entity: E): R
    fun toTrimRequest(entity: E): R {
        return toRequest(entity)
    }
}