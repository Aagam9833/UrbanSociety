package com.aagamshah.urbansociety.domain.usecase

import com.aagamshah.urbansociety.domain.model.societyMember.SocietyMemberModel
import com.aagamshah.urbansociety.domain.repository.SocietyMemberRepository

class InsertSocietyMemberUseCase(
    private val repository: SocietyMemberRepository
) {
    suspend operator fun invoke(member: SocietyMemberModel) = repository.insertSocietyMember(member)
}
