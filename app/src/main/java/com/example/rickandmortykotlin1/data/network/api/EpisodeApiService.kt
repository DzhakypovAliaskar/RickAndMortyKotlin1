package com.example.rickandmortykotlin1.data.network.api

import com.example.rickandmortykotlin1.data.network.dto.RickAndMortyResponse
import com.example.rickandmortykotlin1.data.network.dto.episode.EpisodeDto
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface EpisodeApiService {

    @GET("/api/episode")
    suspend fun fetchEpisodes(
        @Query("page") page: Int,
    ): RickAndMortyResponse<EpisodeDto>

    @GET("/api/episode/{id}")
    suspend fun fetchEpisode(
        @Path("id") id: Int
    ): EpisodeDto
}