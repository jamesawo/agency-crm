/*
 * @Author: james.aworo
 * @Date: 11/1/23
 *
 * @Project: agent-crm
 */

package com.james.crm.api.core.model

import jakarta.persistence.*
import org.hibernate.annotations.GenericGenerator
import org.springframework.data.annotation.CreatedBy
import org.springframework.data.annotation.CreatedDate
import org.springframework.data.annotation.LastModifiedBy
import org.springframework.data.annotation.LastModifiedDate
import org.springframework.data.jpa.domain.support.AuditingEntityListener
import java.time.LocalDateTime

@EntityListeners(AuditingEntityListener::class)
@MappedSuperclass
abstract class Base(
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(name = "id")
    open var id: String? = null
) {

    constructor() : this(null)

    @Column(name = "last_modified_at")
    @LastModifiedDate
    open val lastModifiedAt: LocalDateTime = LocalDateTime.now()

    @Column(name = "created_at")
    @CreatedDate
    open val createdAt: LocalDateTime = LocalDateTime.now()

    @Column(name = "last_modified_by")
    @LastModifiedBy
    open val lastModifiedBy: String? = null

    @Column(name = "created_by")
    @CreatedBy
    open val createdBy: String? = null

    @Column(name = "is_active")
    open val isActive: Boolean = true

}