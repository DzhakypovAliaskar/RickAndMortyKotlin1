package com.example.rickandmortykotlin1.ui.fragment.location.locationsDetail

import com.example.rickandmortykotlin1.common.base.BaseViewModel
import com.example.rickandmortykotlin1.data.network.dto.location.LocationDto
import com.example.rickandmortykotlin1.data.repository.LocationRepository
import com.example.rickandmortykotlin1.ui.state.UIState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class LocationsDetailViewModel constructor(
    private val repository: LocationRepository
) : BaseViewModel() {
    private val _locationState = MutableStateFlow<UIState<LocationDto>>(UIState.Loading())
    var locationState: StateFlow<UIState<LocationDto>> = _locationState

    fun fetchLocation(id: Int) {
        _locationState.subscribeTo {
            repository.fetchLocation(id)
        }
    }
}