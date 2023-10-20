package com.villatte.tp1_premiereappandroid

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import coil.compose.AsyncImage

@Composable
fun DetailsMovies(viewModel: MainViewModel, filmId: String, navController: NavController) {
    val movie by viewModel.detailsMovies.collectAsState()

    LaunchedEffect(true) {
        viewModel.getDetailsFilms(filmId)
    }

    Column() {
        AsyncImage(
            model = "https://image.tmdb.org/t/p/w780" + movie.backdrop_path,
            contentDescription = "Image du film",
            contentScale = ContentScale.Fit
        )
        Text(text = movie.overview)
    }





}


