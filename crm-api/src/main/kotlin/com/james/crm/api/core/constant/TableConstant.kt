/*
 * @Author: james.aworo
 * @Date: 11/1/23
 *
 * @Project: agent-crm
 */

package com.james.crm.api.core.constant

class TableConstant {

    companion object {
        private const val TABLE_PREFIX: String  = "crm"
        const val USER_TABLE: String = TABLE_PREFIX + "_users"

        const val CONTACT_TABLE: String = TABLE_PREFIX + "_contacts"


        const val AGENT_TABLE: String  = TABLE_PREFIX + "_agents"
        const val AGENT_PROFILE: String  = TABLE_PREFIX + "_agents_profile"
    }
}