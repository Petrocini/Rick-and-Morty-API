package com.petrocini.rickandmorty.data.repository

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.petrocini.rickandmorty.data.network.paging.CharacterPaging
import com.petrocini.rickandmorty.data.network.service.ApiService
import com.petrocini.rickandmorty.domain.model.Character
import com.petrocini.rickandmorty.domain.repository.CharacterRepository
import kotlinx.coroutines.flow.Flow

class CharacterRepositoryImpl(private val apiService: ApiService): CharacterRepository {

    override suspend fun getAllCharacters(): Flow<PagingData<Character>> {
        return Pager(
            config = PagingConfig(pageSize = 30, prefetchDistance = 2),
            pagingSourceFactory = { CharacterPaging(apiService) }
        ).flow
    }

}