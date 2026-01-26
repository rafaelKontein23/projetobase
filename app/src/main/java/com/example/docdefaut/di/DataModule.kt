package com.example.docdefaut.di

import com.example.docdefaut.data.remote.api.UserAPI
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit

@Module
@InstallIn(SingletonComponent::class)
class DataModule(
) {
    @Provides
    fun providerUserAPI(
        retrofit: Retrofit
    ): UserAPI {
        return retrofit.create(UserAPI::class.java)
    }
}