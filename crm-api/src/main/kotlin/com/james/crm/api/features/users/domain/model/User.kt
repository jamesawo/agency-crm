/*
 * @Author: james.aworo
 * @Date: 10/30/23
 *
 * @Project: agent-crm
 */

package com.james.crm.api.features.users.domain.model

import com.james.crm.api.features.users.domain.enums.UserTypeEnum
import jakarta.persistence.*
import java.time.LocalDate

@Entity
@Table(name = "crm_user")
class User(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) val id: Long,
    @Column val username: String,
    @Column val password: String,
    @Column val isEnabled: String,
    @Column val expiryDate: LocalDate,
    @Column val userType: UserTypeEnum
    )