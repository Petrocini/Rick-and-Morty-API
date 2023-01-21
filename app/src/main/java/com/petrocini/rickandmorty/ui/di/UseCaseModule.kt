package com.petrocini.rickandmorty.ui.di

import com.petrocini.rickandmorty.domain.repository.CharacterRepository
import com.petrocini.rickandmorty.domain.usecase.GetAllCharactersUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object UseCaseModule {

    @Provides
    @Singleton
    fun provideGetAllCharactersUseCase(characterRepository: CharacterRepository): GetAllCharactersUseCase {
        return GetAllCharactersUseCase(characterRepository::getAllCharacters)
    }

}