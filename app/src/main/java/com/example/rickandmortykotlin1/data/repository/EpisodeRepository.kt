package com.example.rickandmortykotlin1.data.repository

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.example.rickandmortykotlin1.common.base.BaseRepository
import com.example.rickandmortykotlin1.data.network.api.EpisodeApiService
import com.example.rickandmortykotlin1.data.network.dto.episode.EpisodeDto
import com.example.rickandmortykotlin1.data.network.paginsources.EpisodePagingSource
import kotlinx.coroutines.flow.Flow

class EpisodeRepository constructor(
    private val service: EpisodeApiService
) : BaseRepository() {

    fun fetchEpisodes(): Flow<PagingData<EpisodeDto>> {
        return Pager(
            config = PagingConfig(
                pageSize = 10,
            ),
            pagingSourceFactory = {
                EpisodePagingSource(service)
            }
        ).flow
    }
    fun fetchEpisode(id: Int) = doRequest {
        service.fetchEpisode(id)
    }
}