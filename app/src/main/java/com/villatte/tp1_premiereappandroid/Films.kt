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
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import coil.compose.AsyncImage
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Films(viewModel: MainViewModel, navController: NavController) {
    val movies by viewModel.movies.collectAsState()

    LaunchedEffect(true) {
        viewModel.getFilmsInitiaux()
    }

    LazyVerticalGrid(columns = GridCells.Fixed(2), horizontalArrangement = Arrangement.spacedBy(16.dp), verticalArrangement = Arrangement.spacedBy(20.dp)) {
        items(movies) {
                movie ->
            Card(onClick = { navController.navigate("detailsFilms/"+movie.id) }) {
                AsyncImage(
                    model = "https://image.tmdb.org/t/p/w780" + movie.poster_path,
                    contentDescription = "Affiche du film",
                    contentScale = ContentScale.Fit
                )
                Text(text = movie.original_title, fontWeight = FontWeight.Bold)
                Text(text = movie.release_date)
            }
        }
    }

}


