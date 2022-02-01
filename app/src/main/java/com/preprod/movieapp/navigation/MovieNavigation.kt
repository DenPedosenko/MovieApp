package com.preprod.movieapp.navigation

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.preprod.movieapp.screens.DetailsScreen
import com.preprod.movieapp.screens.home.HomeScreen

@ExperimentalAnimationApi
@Composable
fun MovieNavigation() {
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = MovieScreens.HomeScreen.name
    ) {
        composable(MovieScreens.HomeScreen.name) {
            HomeScreen(navController = navController)
        }

        composable(MovieScreens.DetailsScreen.name + "/{movie}",
            arguments = listOf(navArgument(name = "movie") { type = NavType.StringType })
        ) {
            backStackEntry ->
            DetailsScreen(navController = navController, backStackEntry.arguments?.getString("movie"))
        }
    }
}