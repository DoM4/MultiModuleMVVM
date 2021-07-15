package com.domenico.aumenta.multimodulemvvm.di

import com.domenico.aumenta.multimodulemvvm.data.UserRepository
import com.domenico.aumenta.multimodulemvvm.domain.GetUserUseCase
import com.domenico.aumenta.multimodulemvvm.domain.GetUserUseCaseImpl
import com.domenico.aumenta.multimodulemvvm.presentation.UserListMapper
import com.domenico.aumenta.multimodulemvvm.presentation.UserViewModel
import org.koin.dsl.module

val appModule = module {
    single { provideGetUserCase(get()) }
    single { UserRepository(get()) }
    single { UserListMapper() }
    single { UserViewModel(get(), get()) }
}

private fun provideGetUserCase(userRepository: UserRepository): GetUserUseCase =
    GetUserUseCaseImpl(userRepository)