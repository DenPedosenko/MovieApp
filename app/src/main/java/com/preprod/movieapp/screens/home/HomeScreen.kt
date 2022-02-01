package com.preprod.movieapp.screens.home

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.preprod.movieapp.model.Movie
import com.preprod.movieapp.model.getMovies
import com.preprod.movieapp.navigation.MovieScreens
import com.preprod.movieapp.wigets.MovieRow

@ExperimentalAnimationApi
@Composable
fun HomeScreen(
    navController: NavController
) {
    Scaffold(topBar = {
        TopAppBar(
            backgroundColor = MaterialTheme.colors.primary,
            elevation = 5.dp
        ) {
            Text(text = "Movies")
        }
    }) {
        MainContent(navController = navController)
    }
}
@ExperimentalAnimationApi
@Composable
fun MainContent(
    navController: NavController,
    movies: List<Movie> = getMovies()
) {
    Column(modifier = Modifier.padding(top = 12.dp, start = 12.dp, end = 12.dp)) {
        LazyColumn(Modifier.fillMaxSize()) {
            items(items = movies) {
                MovieRow(movie = it) { movie ->
                    navController.navigate(route = MovieScreens.DetailsScreen.name+"/$movie")
                }
            }
        }
    }
}