package com.petrocini.rickandmorty.di

import com.petrocini.rickandmorty.data.network.service.ApiService
import com.petrocini.rickandmorty.data.repository.CharacterRepositoryImpl
import com.petrocini.rickandmorty.domain.repository.CharacterRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @Singleton
    @Provides
    fun providesApiService(): ApiService {
        return Retrofit.Builder()
            .addConverterFactory(MoshiConverterFactory.create())
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