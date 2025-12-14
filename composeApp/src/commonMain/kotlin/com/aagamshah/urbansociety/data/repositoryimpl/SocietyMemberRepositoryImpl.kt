package com.aagamshah.urbansociety.data.repositoryimpl

import com.aagamshah.urbansociety.data.local.societymember.SocietyMemberLocalDataSource
import com.aagamshah.urbansociety.domain.model.societyMember.SocietyMemberModel
import com.aagamshah.urbansociety.domain.model.societyMember.toDomain
import com.aagamshah.urbansociety.domain.model.societyMember.toEntity
import com.aagamshah.urbansociety.domain.repository.SocietyMemberRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map


class SocietyMemberRepositoryImpl(
    private val local: SocietyMemberLocalDataSource
) : SocietyMemberRepository {

    override fun getSocietyMember(id: String): Flow<SocietyMemberModel?> =
        local.observeMember(id).map { it?.toDomain() }

    override suspend fun insertSocietyMember(member: SocietyMemberModel) =
        local.insert(member.toEntity())
}
