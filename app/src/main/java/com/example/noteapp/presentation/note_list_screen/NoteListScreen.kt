package com.example.noteapp.presentation.note_list_screen

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Adb
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.Card
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.noteapp.domain.model.Note
import com.example.noteapp.ui.theme.Purple80

@Composable
fun NoteListScreen(
    navController: NavController,
    noteViewModel : NoteListViewModel = hiltViewModel()
) {
    var noteList by remember {
        mutableStateOf(listOf<Note>())
    }

    noteList = noteViewModel.noteResponse.value.data
    LaunchedEffect(key1 = Unit) {
      noteViewModel.getAllNotes()
        Log.d("noteviewmodellist:",noteViewModel.getAllNotes().toString())
    }

    Scaffold(
        modifier = Modifier.fillMaxSize(),
        floatingActionButton = {
            FloatingActionButton(onClick = {
                navController.navigate("note_screen")
            },
                content = {
                          Image(imageVector = Icons.Filled.Add, contentDescription ="" )
                },
                shape = RoundedCornerShape(20.dp),
                containerColor = Purple80,
                contentColor = Color.White
            )
        }
    ) {innerPadding ->
        LazyColumn(
            modifier = Modifier.padding(innerPadding)
        ) {
            items(noteList){
                NoteListCard(noteData = noteViewModel.noteResponse.value.data, itemIndex = it.id)
                Log.d(  "sdad",noteList.toString())
            }
        }
    }
}

@Composable
fun NoteListCard(noteData: List<Note>?,itemIndex: Int) {
    Column {
     Card(
         modifier = Modifier.wrapContentSize()
     ) {
         Text(text = noteData!![itemIndex].noteTitle)
         Text(text = noteData[itemIndex].noteContent)
     }
    }
}
