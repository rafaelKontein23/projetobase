package com.example.docdefaut.di

import android.content.Context
import com.example.docdefaut.data.remote.api.UserAPI
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
// injeção de depencia com o hilt
@Module
@InstallIn(SingletonComponent::class)
class RetrofitManeger {

    // aqui é a instancia do retrofit universal
    @Provides
    fun providersOkhttp(
        @ApplicationContext context: Context // caso precise do context
    ): OkHttpClient {
        return OkHttpClient.Builder()
            .connectTimeout(30, TimeUnit.SECONDS)
            .readTimeout(30, TimeUnit.SECONDS)
            .build()
    }
    @Provides
    fun providerRetrofit(
        okHttpClient: OkHttpClient
    ): Retrofit {
        return Retrofit
            .Builder()
            .baseUrl("UrlAPI")
            .addConverterFactory(GsonConverterFactory.create())
            .client(okHttpClient)
            .build()
    }

    fun providerUserAPI(
        retrofit: Retrofit
    ): UserAPI {
        return retrofit.create(UserAPI::class.java)
    }
}