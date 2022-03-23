package com.example.rickandmortykotlin1.ui.fragment.character

import androidx.lifecycle.viewModelScope
import androidx.paging.cachedIn
import com.example.rickandmortykotlin1.common.base.BaseViewModel
import com.example.rickandmortykotlin1.data.repository.CharacterRepository

class CharacterViewModel constructor(
    private val repository: CharacterRepository
) : BaseViewModel() {
    fun fetchCharacters() = repository.fetchCharacters().cachedIn(viewModelScope)
}