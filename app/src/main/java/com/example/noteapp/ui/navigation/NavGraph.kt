package com.example.noteapp.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.noteapp.ui.screens.add_edit_note.AddEditNoteScreen
import com.example.noteapp.ui.screens.home.HomeScreen
import com.example.noteapp.ui.screens.splash.SplashScreen

@Composable
fun AppNavGraph(navController: NavHostController = rememberNavController()) {
    NavHost(
        navController = navController, startDestination = Screen.Splash.route,
    ) {
        composable(Routes.SPLASH) {
            SplashScreen(
                navController = navController
            )
        }
        composable(Screen.Home.route) {
            HomeScreen(
                navController = navController
            )
        }
        composable(
            route = Screen.AddEditNote.route,
            arguments = listOf(navArgument("noteId") {
                type = NavType.StringType
                nullable = true
            })
        ) { backStackEntry ->
            val noteId = backStackEntry.arguments?.getString("noteId")?.toIntOrNull()
            AddEditNoteScreen(
                navController = navController,
                note = null
            )
        }

    }
}
