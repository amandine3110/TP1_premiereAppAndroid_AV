package com.villatte.tp1_premiereappandroid

import android.view.Surface
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SearchBar
import androidx.compose.material3.windowsizeclass.WindowSizeClass
import androidx.compose.material3.windowsizeclass.calculateWindowSizeClass
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController

import androidx.compose.material3.Surface

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyScaffold(
    windowClass: WindowSizeClass,
    navController: NavController,
    viewModel: MainViewModel
) {
    //val windowSizeClass = calculateWindowSizeClass(this)

    val navController = rememberNavController()
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentDestination = navBackStackEntry?.destination
    var searchBarActive by remember {
        mutableStateOf(false)
    }

    var searchBarVisible by remember {
        mutableStateOf(false)
    }

    var searchText by remember {
        mutableStateOf("")
    }

    //var value by remember { mutableStateOf("films") }

    Scaffold(

        topBar = {
            if (currentDestination?.route != "profile") {
                if (!searchBarVisible) {
                    TopAppBar(title = { Text("Fav'app") },
                        /**navigationIcon = {
                        IconButton(onClick = { navController.navigate("profile") }) {
                        Icon(
                        imageVector = Icons.Filled.ArrowBack,
                        contentDescription = "Localized description"
                        )
                        }
                        },*/
                        /**navigationIcon = {
                        IconButton(onClick = { navController.navigate("profile") }) {
                        Icon(
                        imageVector = Icons.Filled.ArrowBack,
                        contentDescription = "Localized description"
                        )
                        }
                        },*/
                        /**navigationIcon = {
                        IconButton(onClick = { navController.navigate("profile") }) {
                        Icon(
                        imageVector = Icons.Filled.ArrowBack,
                        contentDescription = "Localized description"
                        )
                        }
                        },*/
                        /**navigationIcon = {
                        IconButton(onClick = { navController.navigate("profile") }) {
                        Icon(
                        imageVector = Icons.Filled.ArrowBack,
                        contentDescription = "Localized description"
                        )
                        }
                        },*/
                        actions = {
                            IconButton(onClick = { searchBarVisible = true }) {
                                Icon(Icons.Filled.Search, contentDescription = null)
                            }
                        }
                    )
                } else {
                    SearchBar(
                        trailingIcon = {
                            IconButton(onClick = { searchBarVisible = false }) {
                                Icon(Icons.Filled.Clear, contentDescription = null)
                            }
                        },
                        query = searchText,
                        onQueryChange = {
                            searchText = it
                        },
                        onSearch = {
                            if (currentDestination?.route == "filmsList") {
                                viewModel.getFilmsViaRecherche(it)
                            }
                            if (currentDestination?.route == "seriesList") {
                                viewModel.getSeriesViaRecherche(it)
                            }
                            if (currentDestination?.route == "actorsList") {
                                viewModel.getPersonnesViaRecherche(it)
                            }
                            searchBarActive = false
                        },
                        active = searchBarActive,
                        onActiveChange = {
                            searchBarActive = it
                        },
                        modifier = Modifier.height(100.dp),
                        placeholder = { Text("Recherche...") }
                    ) {

                    }
                }
            }
        },
        bottomBar = {
            if (currentDestination?.route != "profile") {
                BottomNavigation {
                    BottomNavigationItem(
                        icon = {
                            Image(
                                painterResource(id = R.drawable.baseline_movie_24),
                                contentDescription = null
                            )
                        },
                        label = { Text("Films") },
                        selected = false,
                        onClick = {
                            navController.navigate("filmsList")
                        }
                    )
                    BottomNavigationItem(
                        icon = {
                            Image(
                                painterResource(id = R.drawable.baseline_tv_24),
                                contentDescription = null
                            )
                        },
                        label = { Text("Séries") },
                        selected = false,
                        onClick = {
                            navController.navigate("seriesList")
                        }
                    )
                    BottomNavigationItem(
                        icon = {
                            Icon(
                                Icons.Filled.Person,
                                contentDescription = null
                            )
                        },
                        label = { Text("Acteurs") },
                        selected = false,
                        onClick = {
                            navController.navigate("actorsList")
                        }
                    )
                }
            }
        }
    ) { innerPadding ->
        Surface(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding),
        ) {

            // Contenu principal de votre écran
            Column(
                modifier = Modifier.fillMaxSize(),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                /**
                when (value) {
                    "films" -> Films(viewModel, navController)
                    "series" -> Series(viewModel, navController)
                    "acteurs" -> Actors(viewModel, navController)
                    else -> Text(text = "Contenu inconnu")
                }
                */
            }
            /**
        NavHost(
            navController = navController,
            startDestination = "profile",
            modifier = Modifier.padding(innerPadding)
        ) {
            composable("profile") { Screen(windowClass, navController) }
            composable("filmsList") { Films(viewModel, navController) }
            composable("seriesList") { Series(viewModel, navController) }
            composable("actorsList") { Actors(viewModel, navController) }
            composable("detailsFilms/{filmId}") {
                val filmId = it.arguments?.getString("filmId") ?: ""
                DetailsMovies(viewModel, filmId, navController)
            }
            composable("detailsSeries/{tvId}") {
                val tvId = it.arguments?.getString("tvId") ?: ""
                DetailsSeries(viewModel, tvId, navController)
            }
        */
        }
    }

}