package com.example.rickandmortykotlin1.data.network.paginsources

import com.example.rickandmortykotlin1.common.base.BasePagingSource
import com.example.rickandmortykotlin1.data.network.api.CharacterApiService
import com.example.rickandmortykotlin1.data.network.dto.character.CharacterDto

class CharacterPagingSource (
    private val service: CharacterApiService
) : BasePagingSource<CharacterDto>({ position ->
    service.fetchCharacters(position)
})