package com.villatte.tp1_premiereappandroid

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
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
fun DetailsSeries(viewModel: MainViewModel, tvId: String, navController: NavController) {
    val serie by viewModel.detailsSeries.collectAsState()

    LaunchedEffect(true) {
        viewModel.getDetailsSeries(tvId)
    }

    Column(horizontalAlignment = Alignment.CenterHorizontally, modifier = Modifier.verticalScroll(rememberScrollState())) {
        Spacer(Modifier.height(20.dp))
        Text(text = serie.original_name, style = MaterialTheme.typography.headlineLarge, fontWeight = FontWeight.Bold, modifier = Modifier.padding(15.dp))
        Spacer(Modifier.height(15.dp))
        AsyncImage(
            model = "https://image.tmdb.org/t/p/w780" + serie.backdrop_path,
            contentDescription = "Image de la serie",
            contentScale = ContentScale.Fit
        )
        Row() {
            Column() {
                Spacer(Modifier.height(15.dp))
                AsyncImage(
                    model = "https://image.tmdb.org/t/p/w780" + serie.poster_path,
                    contentDescription = "Image de la serie",
                    modifier = Modifier.size(140.dp)
                )
            }
            Column() {
                Text(text = serie.last_air_date, textAlign = TextAlign.Justify, modifier = Modifier.padding(15.dp))
                Text(text = serie.genres.map { it.name }.joinToString(", "))
            }
        }
        Spacer(Modifier.height(20.dp))
        Text(text = "Synopsis", style = MaterialTheme.typography.headlineSmall, fontWeight = FontWeight.Bold)
        Text(text = serie.overview, textAlign = TextAlign.Justify, modifier = Modifier.padding(15.dp))
        Text(text = "Têtes d'affiche", style = MaterialTheme.typography.headlineSmall, fontWeight = FontWeight.Bold)
        Spacer(Modifier.height(15.dp))
        LazyRow() {
            items(serie.credits.cast) { cast ->
                Card(modifier = Modifier.padding(10.dp)) {
                    AsyncImage(
                        model = "https://image.tmdb.org/t/p/w780" + cast.profile_path,
                        contentDescription = "Photo de la personne",
                        modifier = Modifier.size(200.dp)
                    )
                    Text(text = cast.name, fontWeight = FontWeight.Bold)
                    Text(text = cast.character)
                }
            }
        }
    }
}


