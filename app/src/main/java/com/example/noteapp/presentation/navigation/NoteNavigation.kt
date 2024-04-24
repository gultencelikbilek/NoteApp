package com.example.noteapp.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.ImageBitmap
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.noteapp.presentation.SplashScreen
import com.example.noteapp.presentation.note_list_screen.NoteListScreen
import com.example.noteapp.presentation.note_sreen.NoteScreen

@Composable
fun NoteNavigation() {
       val navController = rememberNavController()

       NavHost(navController = navController, startDestination = "splash_screen") {
           composable(route ="splash_screen") {
               SplashScreen(navController)
           }
           composable(route ="note_screen") {
               NoteScreen(navController)
           }
           composable(route= "note_list_screen"){
               NoteListScreen()
           }
       }
}












