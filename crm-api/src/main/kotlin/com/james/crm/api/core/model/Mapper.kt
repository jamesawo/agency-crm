/*
 * @Author: james.aworo
 * @Date: 11/7/23
 *
 * @Project: agent-crm
 */

package com.james.crm.api.core.model

interface Mapper<R, E> {
    fun toEntity(): E
    fun toRequest(entity: E): R
}