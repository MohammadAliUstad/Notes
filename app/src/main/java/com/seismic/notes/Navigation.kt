package com.seismic.notes

import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.seismic.notes.data.NoteViewModel
import com.seismic.notes.screens.AddScreen
import com.seismic.notes.screens.EditScreen
import com.seismic.notes.screens.HomeScreen

@Composable
fun Navigation(
    noteViewModel: NoteViewModel = viewModel(),
    navHostController: NavHostController = rememberNavController()
) {
    NavHost(
        navController = navHostController,
        startDestination = Screens.HomeScreen.route
    ) {
        composable(Screens.HomeScreen.route) {
            HomeScreen(noteViewModel, navHostController)
        }
        composable(Screens.AddScreen.route) {
            AddScreen(navHostController, noteViewModel)
        }
        composable(Screens.EditScreen.route + "/{id}",
            arguments = listOf(
                navArgument("id") {
                    type = NavType.IntType
                    defaultValue = 0
                    nullable = false
                }
            )
        ) { entry ->
            val id = entry.arguments!!.getInt("id")
            EditScreen(id, navHostController, noteViewModel)
        }
    }
}