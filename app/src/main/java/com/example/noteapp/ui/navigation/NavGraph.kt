package com.example.noteapp.ui.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.noteapp.model.Note
import com.example.noteapp.ui.screens.add_edit_note.AddEditNoteScreen
import com.example.noteapp.ui.screens.home.HomeScreen
import com.example.noteapp.ui.screens.splash.SplashScreen

@Composable
fun AppNavGraph(navController: NavHostController, modifier: Modifier) {
    NavHost(
        navController = navController,
        startDestination = Routes.SPLASH,
        modifier = modifier
    ) {
        composable(Routes.SPLASH) {
            SplashScreen(
                navController = navController
            )
        }
        composable(Routes.HOME) {
            HomeScreen(
                navController = navController
            )
        }
        composable(Routes.ADD_EDIT_NOTE) {
            val note = navController.previousBackStackEntry?.savedStateHandle?.get<Note?>("note")
            AddEditNoteScreen(
                navController = navController,
                note = note
            )
        }

    }
}
