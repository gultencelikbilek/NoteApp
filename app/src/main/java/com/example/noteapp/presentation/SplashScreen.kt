package com.example.noteapp.presentation

import androidx.compose.foundation.Image
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.res.painterResource
import androidx.navigation.NavHostController
import com.example.noteapp.R
import kotlinx.coroutines.delay

@Composable
fun SplashScreen(
    navController: NavHostController
) {

    LaunchedEffect(key1 = true ){
        delay(3000)
        navController.navigate("note_screen")
    }


    Image(painter = painterResource(id = R.drawable.note_app), contentDescription = "")
}
