package com.petrocini.rickandmorty.domain.repository

import androidx.paging.PagingData
import kotlinx.coroutines.flow.Flow
import com.petrocini.rickandmorty.domain.model.Character

interface CharacterRepository {
    suspend fun getAllCharacters(): Flow<PagingData<Character>>
}