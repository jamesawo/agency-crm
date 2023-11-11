/*
 * @Author: james.aworo
 * @Date: 11/1/23
 *
 * @Project: agent-crm
 */

package com.james.crm.api.modules.people.domain.model.submodel

import com.james.crm.api.core.constant.DatabaseTable.Companion.TEAM
import com.james.crm.api.core.constant.DatabaseTable.Companion.TEAM_TASKS
import com.james.crm.api.core.model.Base
import com.james.crm.api.modules.people.domain.model.Agent
import com.james.crm.api.modules.people.domain.model.Manager
import jakarta.persistence.*

@Entity
@Table(name = TEAM)
class Team(id: String? = null) : Base(id) {

    var title: String = ""

    @ManyToOne(cascade = [CascadeType.ALL], fetch = FetchType.LAZY)
    var manager: Manager? = Manager()

    @OneToMany(mappedBy = "team", cascade = [CascadeType.ALL], fetch = FetchType.LAZY)
    var agents: List<Agent>? = emptyList()

    @OneToOne(cascade = [CascadeType.ALL])
    var location: Location? = Location()

    var budget: Double = 0.00

    @ManyToMany(cascade = [CascadeType.ALL], fetch = FetchType.LAZY)
    @JoinTable(
        name = TEAM_TASKS,
        joinColumns = [JoinColumn(name = "team_id")],
        inverseJoinColumns = [JoinColumn(name = "task_id")]
    )
    var tasks: List<Task>? = mutableListOf()

}