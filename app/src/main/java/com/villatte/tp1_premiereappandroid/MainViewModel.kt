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
    val detailsMovies = MutableStateFlow<DetailsFilms>(DetailsFilms())
    val detailsSeries = MutableStateFlow<DetailsSeries>(DetailsSeries())

    val api_key = "d936676cee467fd5bde1950ab82959ee"

    val service = Retrofit.Builder().baseUrl("https://api.themoviedb.org/3/").addConverterFactory(MoshiConverterFactory.create()).build().create(TmdbAPI::class.java)

    fun getFilmsInitiaux() {
        viewModelScope.launch {
            movies.value = service.lastmovies(api_key, "fr").results
        }
    }

    fun getSeriesInitiales() {
        viewModelScope.launch {
            series.value = service.lastseries(api_key, "fr").results
        }
    }

    fun getPersonnesInitiales() {
        viewModelScope.launch {
            personnes.value = service.lastperson(api_key, "fr").results
        }
    }

    fun getFilmsViaRecherche(searchText: String) {
        viewModelScope.launch {
            movies.value = service.moviesKeyWord(api_key, searchText, "fr").results
        }
    }

    fun getSeriesViaRecherche(searchText: String) {
        viewModelScope.launch {
            series.value = service.seriesKeyWord(api_key, searchText, "fr").results
        }
    }

    fun getPersonnesViaRecherche(searchText: String) {
        viewModelScope.launch {
            personnes.value = service.personKeyWord(api_key, searchText, "fr").results
        }
    }

    fun getDetailsFilms(filmId: String) {
        viewModelScope.launch {
            detailsMovies.value = service.moviesDetails(filmId, api_key, "fr")
        }
    }

    fun getDetailsSeries(tvId: String) {
        viewModelScope.launch {
            detailsSeries.value = service.seriesDetails(tvId, api_key, "fr")
        }
    }

}