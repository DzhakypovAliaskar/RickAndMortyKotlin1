package com.example.rickandmortykotlin1.servicelocatior

import com.example.rickandmortykotlin1.data.network.RetrofitClient
import com.example.rickandmortykotlin1.data.repository.CharacterRepository
import com.example.rickandmortykotlin1.data.repository.EpisodeRepository
import com.example.rickandmortykotlin1.data.repository.LocationRepository
import com.example.rickandmortykotlin1.ui.fragment.character.CharacterViewModel
import com.example.rickandmortykotlin1.ui.fragment.character.charactersDetail.CharactersDetailViewModel
import com.example.rickandmortykotlin1.ui.fragment.episode.EpisodeViewModel
import com.example.rickandmortykotlin1.ui.fragment.episode.episodesDetail.EpisodesDetailViewModel
import com.example.rickandmortykotlin1.ui.fragment.location.LocationViewModel
import com.example.rickandmortykotlin1.ui.fragment.location.locationsDetail.LocationsDetailViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val networkModule = module {
    single { RetrofitClient() }
    single { get<RetrofitClient>().provideCharacterApiService() }
    single { get<RetrofitClient>().provideEpisodeApiService() }
    single { get<RetrofitClient>().provideLocationApiService() }
}
val repositoriesModule = module {
    factory { CharacterRepository(get()) }
    factory { EpisodeRepository(get()) }
    factory { LocationRepository(get()) }
}

val viewModelsModule = module {
    viewModel { CharacterViewModel(get()) }
    viewModel { EpisodeViewModel(get()) }
    viewModel { LocationViewModel(get()) }
    viewModel { CharactersDetailViewModel(get()) }
    viewModel { EpisodesDetailViewModel(get()) }
    viewModel { LocationsDetailViewModel(get()) }
}