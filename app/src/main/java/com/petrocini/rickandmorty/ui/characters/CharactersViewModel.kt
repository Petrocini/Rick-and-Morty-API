package com.petrocini.rickandmorty.ui.characters

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.petrocini.rickandmorty.domain.usecase.GetAllCharactersUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CharactersViewModel @Inject constructor(
    private val getAllCharactersUseCase: GetAllCharactersUseCase
): ViewModel() {

    private val _charactersUiState = MutableStateFlow(CharactersUiState())
    val charactersUiState: StateFlow<CharactersUiState> get() = _charactersUiState

    init {
        getAllCharacters()
    }

    fun getAllCharacters() {
        viewModelScope.launch {
            getAllCharactersUseCase().collect { characters ->
                _charactersUiState.value = charactersUiState.value.copy(
                    characters = characters,
                    isLoading = true
                )
            }
        }
    }

}