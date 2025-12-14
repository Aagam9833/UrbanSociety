package com.aagamshah.urbansociety.domain.model.societyMember

import com.aagamshah.urbansociety.db.Society_member

fun Society_member.toDomain(): SocietyMemberModel =
    SocietyMemberModel(
        id = id,
        name = name,
        photoUrl = photo_url,
        email = email,
        phoneNumber = phone_number,
        societyId = society_id
    )

fun SocietyMemberModel.toEntity(): Society_member =
    Society_member(
        id = id,
        name = name,
        photo_url = photoUrl,
        email = email,
        phone_number = phoneNumber,
        society_id = societyId
    )
