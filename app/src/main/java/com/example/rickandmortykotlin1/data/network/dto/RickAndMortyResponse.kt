package com.example.rickandmortykotlin1.data.network.dto

import com.google.gson.annotations.SerializedName

class RickAndMortyResponse<T> (
    @SerializedName("info")
    val info: Info,
    @SerializedName("results")
    val results: List<T>
)