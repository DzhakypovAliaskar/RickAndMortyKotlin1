package com.example.rickandmortykotlin1.data.network.paginsources

import com.example.rickandmortykotlin1.common.base.BasePagingSource
import com.example.rickandmortykotlin1.data.network.api.EpisodeApiService
import com.example.rickandmortykotlin1.data.network.dto.episode.EpisodeDto

class EpisodePagingSource(
    private val service: EpisodeApiService
) : BasePagingSource<EpisodeDto>({ position ->
    service.fetchEpisodes(position)
})