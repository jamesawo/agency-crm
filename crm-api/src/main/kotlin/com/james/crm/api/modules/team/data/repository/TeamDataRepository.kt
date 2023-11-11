/*
 * @Author: james.aworo
 * @Date: 11/11/23
 *
 * @Project: agent-crm
 */

package com.james.crm.api.modules.team.data.repository

import com.james.crm.api.modules.team.domain.Team
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface TeamDataRepository : JpaRepository<Team, String>