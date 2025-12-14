package com.aagamshah.urbansociety.domain.model.societyMember

data class SocietyMemberModel(
    val id: String,
    val name: String,
    val photoUrl: String,
    val email: String,
    val phoneNumber: String,
    val societyId: String,
)