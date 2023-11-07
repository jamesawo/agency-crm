/*
 * @Author: james.aworo
 * @Date: 11/1/23
 *
 * @Project: agent-crm
 */

package com.james.crm.api.core.constant

class Table {

    companion object {
        private const val TABLE_PREFIX: String = "crm_"
        const val USER: String = TABLE_PREFIX + "users"
        const val CONTACT: String = TABLE_PREFIX + "contacts"
        const val CLIENT_TABLE: String = TABLE_PREFIX + "clients"
        const val AGENT_TABLE: String = TABLE_PREFIX + "agents"
        const val MANAGER_TABLE: String = TABLE_PREFIX + "managers"
        const val PROFILE_TABLE: String = TABLE_PREFIX + "profiles"
        const val LOCATION_TABLE: String = TABLE_PREFIX + "locations"
        const val RESOURCE_TABLE: String = TABLE_PREFIX + "resources"
        const val TASK_TABLE: String = TABLE_PREFIX + "tasks"
        const val TEAM_TABLE: String = TABLE_PREFIX + "teams"
        const val BANK_ACC_TABLE: String = TABLE_PREFIX + "bank_accounts"
    }
}