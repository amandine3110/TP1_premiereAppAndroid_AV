package com.villatte.tp1_premiereappandroid

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import coil.compose.AsyncImage

@Composable
fun DetailsMovies(viewModel: MainViewModel, filmId: String, navController: NavController) {
    val movie by viewModel.detailsMovies.collectAsState()

    LaunchedEffect(true) {
        viewModel.getDetailsFilms(filmId)
    }

    Column(horizontalAlignment = Alignment.CenterHorizontally, modifier = Modifier.verticalScroll(rememberScrollState())) {
        Spacer(Modifier.height(20.dp))
        Text(text = movie.original_title, style = MaterialTheme.typography.headlineLarge, fontWeight = FontWeight.Bold, modifier = Modifier.padding(15.dp))
        Spacer(Modifier.height(15.dp))
        AsyncImage(
            model = "https://image.tmdb.org/t/p/w780" + movie.backdrop_path,
            contentDescription = "Image du film",
            //contentScale = ContentScale.Fit
        Modifier.fillMaxWidth()
        )
        Row() {
            Column() {
                Spacer(Modifier.height(15.dp))
                AsyncImage(
                    model = "https://image.tmdb.org/t/p/w780" + movie.poster_path,
                    contentDescription = "Image du film",
                    modifier = Modifier.size(140.dp)
                )
            }
            Column(verticalArrangement = Arrangement.Center) {
                Text(text = movie.release_date, textAlign = TextAlign.Justify, modifier = Modifier.padding(15.dp))
                Text(movie.genres.map { it.name}.joinToString(", "))
                }
            }
        Spacer(Modifier.height(20.dp))
        Text(text = "Synopsis", style = MaterialTheme.typography.headlineSmall, fontWeight = FontWeight.Bold, textAlign = TextAlign.Left)
        Text(text = movie.overview, textAlign = TextAlign.Justify, modifier = Modifier.padding(15.dp))
        Text(text = "Têtes d'affiche", style = MaterialTheme.typography.headlineSmall, fontWeight = FontWeight.Bold, textAlign = TextAlign.Left)
        //LazyVerticalGrid(columns = GridCells.Fixed(2), horizontalArrangement = Arrangement.spacedBy(16.dp), verticalArrangement = Arrangement.spacedBy(20.dp)) {
        Spacer(Modifier.height(15.dp))
        LazyRow() {
            items(movie.credits.cast) {
            //items(movie.credits.cast) {
                    cast ->
            //movie.credits.cast.forEach {
                Card() {
                    AsyncImage(
                        model = "https://image.tmdb.org/t/p/w780" + cast.profile_path,
                        contentDescription = "Photo de la personne",
                        //contentScale = ContentScale.Fit,
                        modifier = Modifier.size(180.dp)
                    )
                    Text(text = cast.name, fontWeight = FontWeight.Bold)
                    Text(text = cast.character)
                }
            }
        }
        //}
    }





}


