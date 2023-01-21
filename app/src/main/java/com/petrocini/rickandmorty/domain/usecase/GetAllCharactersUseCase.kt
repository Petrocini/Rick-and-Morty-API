package com.petrocini.rickandmorty.domain.usecase

import androidx.paging.PagingData
import com.petrocini.rickandmorty.domain.model.Character
import kotlinx.coroutines.flow.Flow

fun interface GetAllCharactersUseCase {
    suspend operator fun invoke(): Flow<PagingData<Character>>
}