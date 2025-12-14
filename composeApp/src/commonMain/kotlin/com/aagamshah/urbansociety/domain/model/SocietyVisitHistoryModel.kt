package com.aagamshah.urbansociety.domain.model

data class SocietyVisitHistoryModel(
    val id: String,
    val timeInMillis: Long,
    val apartmentNumber: String,
    val societyId: String,
    val visitorName: String,
    val visitationPurpose: String,
    val visitorPhoto: String,
    val visitorContact: String,
)
