/*
 * @Author: james.aworo
 * @Date: 11/15/23
 *
 * @Project: agent-crm
 */

package com.james.crm.api.modules.pipeline.data.repository

import com.james.crm.api.modules.pipeline.domain.Stage
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface StageDataRepository : JpaRepository<Stage, String>