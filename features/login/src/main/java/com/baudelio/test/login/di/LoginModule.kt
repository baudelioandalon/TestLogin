package com.baudelio.test.login.di

import com.baudelio.test.core.utils.base.UseCase
import com.baudelio.test.login.data.DefaultAuthRepository
import com.baudelio.test.login.data.datasource.GetAuthDataSource
import com.baudelio.test.login.data.datasource.remote.RemoteAuthDataSource
import com.baudelio.test.login.domain.AuthRepository
import com.baudelio.test.login.usecase.AuthUseCase
import com.baudelio.test.login.viewmodel.LoginViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.qualifier.named
import org.koin.dsl.module

val loginModule = module {
    single<GetAuthDataSource>(named("RemoteAuthDataSource")) {
        RemoteAuthDataSource()
    }
    single<AuthRepository>(named("DefaultAuthRepository")) {
        DefaultAuthRepository(
            get(named("RemoteAuthDataSource"))
        )
    }
    single<UseCase<AuthUseCase.Input, AuthUseCase.Output>>(named("AuthUseCase")) {
        AuthUseCase(get(named("DefaultAuthRepository")))
    }

    viewModel {
        LoginViewModel(
            get(qualifier = named("AuthUseCase"))
        )
    }
}