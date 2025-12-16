package com.aagamshah.urbansociety.di

import com.aagamshah.urbansociety.data.local.societymember.SocietyMemberLocalDataSource
import com.aagamshah.urbansociety.data.local.societymember.SqlDelightSocietyMemberLocalDataSource
import com.aagamshah.urbansociety.data.repositoryimpl.LoginRepositoryImpl
import com.aagamshah.urbansociety.data.repositoryimpl.SocietyMemberRepositoryImpl
import com.aagamshah.urbansociety.domain.repository.LoginRepository
import com.aagamshah.urbansociety.domain.repository.SocietyMemberRepository
import com.aagamshah.urbansociety.domain.usecase.GetSocietyMemberUseCase
import com.aagamshah.urbansociety.domain.usecase.InsertSocietyMemberUseCase
import com.aagamshah.urbansociety.domain.usecase.LoginUseCase
import com.aagamshah.urbansociety.presentation.loginscreen.LoginScreenViewModel
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.IO
import kotlinx.coroutines.SupervisorJob
import org.koin.dsl.module

val commonModule = module {

    // ViewModels
    factory {
        LoginScreenViewModel(
            loginUseCase = get(),
            coroutineScope = CoroutineScope(Dispatchers.Main.immediate + SupervisorJob())
        )
    }

    // Dispatchers
    single<CoroutineDispatcher> { Dispatchers.IO }

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
    single<LoginRepository> {
        LoginRepositoryImpl()
    }

    // Use cases
    factory { GetSocietyMemberUseCase(get()) }
    factory { InsertSocietyMemberUseCase(get()) }
    factory { LoginUseCase(get()) }
}
