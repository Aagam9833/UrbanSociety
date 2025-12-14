package com.aagamshah.urbansociety.domain.usecase

import com.aagamshah.urbansociety.domain.model.societyMember.SocietyMemberModel
import com.aagamshah.urbansociety.domain.repository.SocietyMemberRepository
import kotlinx.coroutines.flow.Flow

class GetSocietyMemberUseCase(
    private val repository: SocietyMemberRepository
) {
    operator fun invoke(id: String): Flow<SocietyMemberModel?> =
        repository.getSocietyMember(id)
}
