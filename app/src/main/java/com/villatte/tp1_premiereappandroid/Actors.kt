package com.villatte.tp1_premiereappandroid

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage

@Composable
fun Actors(viewModel: MainViewModel) {
    val actors by viewModel.personnes.collectAsState()

    if (actors.isEmpty()) viewModel.getPersonnesInitiales()

    LazyVerticalGrid(columns = GridCells.Fixed(2), horizontalArrangement = Arrangement.spacedBy(16.dp), verticalArrangement = Arrangement.spacedBy(20.dp)) {
        items(actors) {
                actor ->

Card() {
    AsyncImage(
        model = "https://image.tmdb.org/t/p/w780" + actor.profile_path,
        contentDescription = "Photo de la personne",
        contentScale = ContentScale.Fit
    )
    Text(text = actor.name, fontWeight = FontWeight.Bold)
}
                }
    }

}