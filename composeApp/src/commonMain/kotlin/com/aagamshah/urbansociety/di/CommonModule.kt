package com.aagamshah.urbansociety.di

import com.aagamshah.urbansociety.data.local.societymember.SocietyMemberLocalDataSource
import com.aagamshah.urbansociety.data.local.societymember.SqlDelightSocietyMemberLocalDataSource
import com.aagamshah.urbansociety.data.repositoryimpl.SocietyMemberRepositoryImpl
import com.aagamshah.urbansociety.domain.repository.SocietyMemberRepository
import com.aagamshah.urbansociety.domain.usecase.GetSocietyMemberUseCase
import com.aagamshah.urbansociety.domain.usecase.InsertSocietyMemberUseCase
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import org.koin.dsl.module

val commonModule = module {

    // Dispatchers
    single<CoroutineDispatcher> { Dispatchers.Default }

    // Data sources
    single<SocietyMemberLocalDataSource> {
        SqlDelightSocietyMemberLocalDataSource(
            database = get(),
            dispatcher = get()
        )
    }

    // Repository
    single<SocietyMemberRepository> {
        SocietyMemberRepositoryImpl(get())
    }

    // Use cases
    factory { GetSocietyMemberUseCase(get()) }
    factory { InsertSocietyMemberUseCase(get()) }
}
