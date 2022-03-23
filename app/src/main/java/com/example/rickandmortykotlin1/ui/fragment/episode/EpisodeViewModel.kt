package com.example.rickandmortykotlin1.ui.fragment.episode

import androidx.lifecycle.viewModelScope
import androidx.paging.cachedIn
import com.example.rickandmortykotlin1.common.base.BaseViewModel
import com.example.rickandmortykotlin1.data.repository.EpisodeRepository

class EpisodeViewModel constructor(
    private val repository: EpisodeRepository
) : BaseViewModel() {
    fun fetchEpisode() = repository.fetchEpisodes().cachedIn(viewModelScope)
}