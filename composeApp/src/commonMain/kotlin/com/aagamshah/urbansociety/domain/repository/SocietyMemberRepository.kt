package com.aagamshah.urbansociety.domain.repository

import com.aagamshah.urbansociety.domain.model.societyMember.SocietyMemberModel
import kotlinx.coroutines.flow.Flow

interface SocietyMemberRepository {
    fun getSocietyMember(id: String): Flow<SocietyMemberModel?>
    suspend fun insertSocietyMember(member: SocietyMemberModel)
}
