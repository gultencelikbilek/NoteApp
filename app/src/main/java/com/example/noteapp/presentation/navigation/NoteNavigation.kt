package com.example.noteapp.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.noteapp.presentation.SplashScreen
import com.example.noteapp.presentation.note_list_screen.NoteListScreen

@Composable
fun NoteNavigation() {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = "splash_screen"){
        composable("splash_screen"){
            SplashScreen()
        }
        composable("note_list_screen"){
            NoteListScreen()
        }
    }
}
