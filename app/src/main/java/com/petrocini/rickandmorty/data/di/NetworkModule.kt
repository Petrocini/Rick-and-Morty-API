package com.petrocini.rickandmorty.data.di

import com.petrocini.rickandmorty.data.network.service.ApiService
import com.petrocini.rickandmorty.data.repository.CharacterRepositoryImpl
import com.petrocini.rickandmorty.domain.repository.CharacterRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @Singleton
    @Provides
    fun providesApiService(): ApiService {
        val okHttpClient = OkHttpClient.Builder()
            .readTimeout(60, TimeUnit.SECONDS)
            .build()
        return Retrofit.Builder()
            .addConverterFactory(MoshiConverterFactory.create())
            .client(okHttpClient)
            .baseUrl(ApiService.BASE_API_URL)
            .build()
            .create(ApiService::class.java)
    }

    @Singleton
    @Provides
    fun providesCharacterRepository(apiService: ApiService): CharacterRepository {
        return CharacterRepositoryImpl(apiService)
    }

}