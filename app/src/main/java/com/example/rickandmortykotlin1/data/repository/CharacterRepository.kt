package com.example.rickandmortykotlin1.data.repository

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.example.rickandmortykotlin1.common.base.BaseRepository
import com.example.rickandmortykotlin1.data.network.api.CharacterApiService
import com.example.rickandmortykotlin1.data.network.dto.character.CharacterDto
import com.example.rickandmortykotlin1.data.network.paginsources.CharacterPagingSource
import kotlinx.coroutines.flow.Flow

class CharacterRepository constructor(
    private val service: CharacterApiService
) : BaseRepository() {

    fun fetchCharacters(): Flow<PagingData<CharacterDto>> {
        return Pager(
            config = PagingConfig(
                pageSize = 10,
            ),
            pagingSourceFactory = {
                CharacterPagingSource(service)
            }
        ).flow
    }

    fun fetchCharacter(id: Int) = doRequest {
        service.fetchCharacter(id)
    }
}