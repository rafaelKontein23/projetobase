package com.example.docdefaut.di

import androidx.lifecycle.ViewModel
import com.example.docdefaut.data.remote.repository.UserRemoteRepositoryImpl
import com.example.docdefaut.domain.login.repository.UserRemoteRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

// injeção de depencia com o hilt
@Module
@InstallIn(SingletonComponent::class)
abstract class DomainModule {
    @Binds
    abstract fun bindsUserRemoteRepositoryImpl(
        impl: UserRemoteRepositoryImpl
    ):UserRemoteRepository
}