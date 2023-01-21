package com.petrocini.rickandmorty.ui.characters

import androidx.paging.PagingData
import com.petrocini.rickandmorty.domain.model.Character

data class CharactersUiState(
    val characters: PagingData<Character> = PagingData.empty(),
    val isLoading: Boolean = false
)