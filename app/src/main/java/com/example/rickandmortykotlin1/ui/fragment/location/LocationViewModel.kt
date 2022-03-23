package com.example.rickandmortykotlin1.ui.fragment.location

import androidx.lifecycle.viewModelScope
import androidx.paging.cachedIn
import com.example.rickandmortykotlin1.common.base.BaseViewModel
import com.example.rickandmortykotlin1.data.repository.LocationRepository

class LocationViewModel constructor(
    private val repository: LocationRepository
) : BaseViewModel() {
    fun fetchLocations() = repository.fetchLocations().cachedIn(viewModelScope)
}