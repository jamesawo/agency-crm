/*
 * @Author: james.aworo
 * @Date: 11/7/23
 *
 * @Project: agent-crm
 */

package com.james.crm.api.modules.people.domain.repository

import com.james.crm.api.modules.people.domain.model.User
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface UserRepository: JpaRepository<User, String> {
}