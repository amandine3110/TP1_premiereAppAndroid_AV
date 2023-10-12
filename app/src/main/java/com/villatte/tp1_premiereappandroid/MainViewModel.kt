package com.villatte.tp1_premiereappandroid

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

class MainViewModel : ViewModel() {

    val movies = MutableStateFlow<List<Film>>(listOf())
    val series = MutableStateFlow<List<Serie>>(listOf())
    val personnes = MutableStateFlow<List<Personne>>(listOf())
    val searchMovies = MutableStateFlow<List<Film>>(listOf())

    val api_key = "d936676cee467fd5bde1950ab82959ee"

    val service = Retrofit.Builder().baseUrl("https://api.themoviedb.org/3/").addConverterFactory(MoshiConverterFactory.create()).build().create(TmdbAPI::class.java)

    fun getFilmsInitiaux() {
        viewModelScope.launch {
            movies.value = service.lastmovies(api_key).results
        }
    }

    fun getSeriesInitiales() {
        viewModelScope.launch {
            series.value = service.lastseries(api_key).results
        }
    }

    fun getPersonnesInitiales() {
        viewModelScope.launch {
            personnes.value = service.lastperson(api_key).results
        }
    }

    fun getFilmsViaRecherche(searchText: String) {
        viewModelScope.launch {
            searchMovies.value = service.moviesKeyWord(api_key, searchText).results
        }
    }

}