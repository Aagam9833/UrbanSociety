package com.aagamshah.urbansociety.data.local.societymember

import com.aagamshah.urbansociety.db.Society_member
import kotlinx.coroutines.flow.Flow

interface SocietyMemberLocalDataSource {
    fun observeMember(id: String): Flow<Society_member?>
    suspend fun insert(member: Society_member)
}