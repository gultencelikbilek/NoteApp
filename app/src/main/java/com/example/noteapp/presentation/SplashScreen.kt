package com.example.noteapp.presentation

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.navigation.compose.rememberNavController
import com.example.noteapp.R
import kotlinx.coroutines.delay

@Composable
fun SplashScreen() {

    val navController = rememberNavController()
    LaunchedEffect(key1 =true ){
        delay(3000L)
        navController.navigate("note_list_screen")

    }
    
    Box(modifier = Modifier.fillMaxSize()) {
        Image(
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.Fit,
            painter = painterResource(id = R.drawable.note_app),
            contentDescription = "note_app"
        )
       

    }
}