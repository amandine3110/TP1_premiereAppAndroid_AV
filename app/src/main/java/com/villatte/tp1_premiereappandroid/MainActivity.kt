package com.villatte.tp1_premiereappandroid

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.DockedSearchBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SearchBar
import androidx.compose.material3.Surface
import androidx.compose.material3.windowsizeclass.ExperimentalMaterial3WindowSizeClassApi
import androidx.compose.material3.windowsizeclass.calculateWindowSizeClass
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavController
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.villatte.tp1_premiereappandroid.ui.theme.TP1_premiereAppAndroidTheme

class MainActivity : ComponentActivity() {

    @OptIn(ExperimentalMaterial3WindowSizeClassApi::class, ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val viewModel: MainViewModel by viewModels()

        setContent {
            val windowSizeClass = calculateWindowSizeClass(this)
            TP1_premiereAppAndroidTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {


                    val navController = rememberNavController()

                    var searchBarVisible by remember {
                        mutableStateOf(false)
                    }

                    var searchText by remember {
                        mutableStateOf("")
                    }

                    Scaffold(
                        topBar = {
                            if (!searchBarVisible) {
                                TopAppBar(title = { Text("Recherche") },
                                    navigationIcon = {
                                        IconButton(onClick = { searchBarVisible = true }) {
                                            Icon(Icons.Filled.Search, contentDescription = null)
                                        }
                                    },
                                    actions = {


                                    }
                                )
                            } else {
                                DockedSearchBar(
                                    query = searchText,
                                    onQueryChange = {},
                                    onSearch = {

                                    },
                                    active = true,
                                    onActiveChange = {

                                    }
                                ) {

                                }
                            }
                            }
                        ,
                        bottomBar = {
                            BottomNavigation {
                                val navBackStackEntry by navController.currentBackStackEntryAsState()
                                val currentDestination = navBackStackEntry?.destination
                                BottomNavigationItem(
                                    icon = {
                                        Image(
                                            painterResource(id = R.drawable.baseline_movie_24),
                                            contentDescription = null
                                        ) },
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
                    ) { innerPadding ->
                        NavHost(
                            navController = navController,
                            startDestination = "profile",
                            modifier = Modifier.padding(innerPadding)
                        ) {
                            composable("profile") { Screen(windowSizeClass, navController) }
                            composable("filmsList") { Films(viewModel) }
                            composable("seriesList") { Series(viewModel) }
                            composable("actorsList") { Actors(viewModel) }
                        }
                    }


                }
            }
        }
    }
}


