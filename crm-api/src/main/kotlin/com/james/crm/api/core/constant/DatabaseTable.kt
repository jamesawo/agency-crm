/*
 * @Author: james.aworo
 * @Date: 11/1/23
 *
 * @Project: agent-crm
 */

package com.james.crm.api.core.constant

class DatabaseTable {

    companion object {
        private const val PREFIX: String = "crm_"
        const val USER: String = PREFIX + "users"
        const val CONTACT: String = PREFIX + "contacts"
        const val EMERGENCY_CONTACT: String = PREFIX + "emergency_contacts"
        const val CLIENT: String = PREFIX + "clients"
        const val AGENT: String = PREFIX + "agents"
        const val MANAGER: String = PREFIX + "managers"
        const val PROFILE: String = PREFIX + "profiles"
        const val LOCATION: String = PREFIX + "locations"
        const val RESOURCE: String = PREFIX + "resources"
        const val TASK: String = PREFIX + "tasks"
        const val TEAM: String = PREFIX + "teams"
        const val TEAM_TASKS: String = PREFIX + "team_tasks"
        const val BANK_ACCOUNT: String = PREFIX + "bank_accounts"
    }
}