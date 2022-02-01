package com.preprod.movieapp.screens

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.preprod.movieapp.model.getMovieById
import com.preprod.movieapp.wigets.ErrorButton
import com.preprod.movieapp.wigets.HorizontalScrollableImageView
import com.preprod.movieapp.wigets.MovieRow

@ExperimentalAnimationApi
@Composable
fun DetailsScreen(navController: NavHostController, movieId: String?) {
    val movie = movieId?.let { getMovieById(movieId) }

    Scaffold(topBar = {
        TopAppBar(
            backgroundColor = MaterialTheme.colors.primary,
            elevation = 5.dp
        ) {
            Row(horizontalArrangement = Arrangement.Start) {
                Icon(
                    imageVector = Icons.Default.ArrowBack,
                    contentDescription = "Arrow Back",
                    modifier = Modifier.clickable {
                        navController.popBackStack()
                    })
                Spacer(modifier = Modifier.width(100.dp))
                Text(text = "Movies")
            }
        }
    }) {
        Surface(modifier = Modifier.fillMaxSize()) {
            if (movie != null) {
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    MovieRow(movie = movie)
                    Spacer(modifier = Modifier.height(8.dp))
                    Divider()
                    Text(text = "Movie Images")
                    HorizontalScrollableImageView(movie.images)
                }
            } else {
                ErrorButton {}
            }
        }
    }
}