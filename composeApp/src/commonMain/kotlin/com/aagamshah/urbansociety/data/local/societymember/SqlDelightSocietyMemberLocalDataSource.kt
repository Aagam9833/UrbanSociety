package com.aagamshah.urbansociety.data.local.societymember

import app.cash.sqldelight.coroutines.asFlow
import app.cash.sqldelight.coroutines.mapToOneOrNull
import com.aagamshah.urbansociety.db.Society_member
import com.aagamshah.urbansociety.db.UrbanSocietyDatabase
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow

class SqlDelightSocietyMemberLocalDataSource(
    private val database: UrbanSocietyDatabase,
    private val dispatcher: CoroutineDispatcher
) : SocietyMemberLocalDataSource {

    override fun observeMember(id: String): Flow<Society_member?> =
        database.societyMemberQueries
            .selectMemberById(id)
            .asFlow()
            .mapToOneOrNull(dispatcher)

    override suspend fun insert(member: Society_member) {
        database.societyMemberQueries.insertMember(
            id = member.id,
            name = member.name,
            photo_url = member.photo_url,
            email = member.email,
            phone_number = member.phone_number,
            society_id = member.society_id
        )
    }
}
