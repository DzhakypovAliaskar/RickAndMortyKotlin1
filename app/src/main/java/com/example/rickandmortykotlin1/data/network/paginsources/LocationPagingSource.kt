package com.example.rickandmortykotlin1.data.network.paginsources

import com.example.rickandmortykotlin1.common.base.BasePagingSource
import com.example.rickandmortykotlin1.data.network.api.LocationApiService
import com.example.rickandmortykotlin1.data.network.dto.location.LocationDto

class LocationPagingSource(
    private val service: LocationApiService
) : BasePagingSource<LocationDto>({ position ->
    service.fetchLocations(position)
})