package com.example.noteapp.presentation.note_sreen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import com.example.noteapp.domain.model.Note

@Composable
fun NoteScreen(
    navController: NavHostController,
    addNoteViewModel: AddNoteViewModel = viewModel()
) {

   // val addNoteViewModel : AddNoteViewModel = hiltViewModel()

    var title by remember {
        mutableStateOf("")
    }
    var content by remember {
        mutableStateOf("")
    }
    Column(
        modifier = Modifier
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "NOTE",
            fontSize = 32.sp,
            color = Color.Black,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(10.dp)
        )
        Spacer(modifier = Modifier.height(20.dp))
        TextField(
            value = title,
            onValueChange = {
                title = it
            },
            modifier = Modifier
                .width(400.dp)
                .height(70.dp)
                .padding(start = 10.dp, end = 10.dp),
            placeholder = {
                Text(text = "Add New Note Title")
            },
            keyboardOptions = KeyboardOptions.Default.copy(
                imeAction = ImeAction.Next
            ),
            maxLines = 1,
            shape = RoundedCornerShape(20.dp),
            colors = TextFieldDefaults.colors(
                unfocusedContainerColor = Color.Transparent,
                focusedContainerColor = Color.White,
                focusedIndicatorColor = Color.Black,
                unfocusedIndicatorColor = Color.Transparent
            )
        )

        TextField(
            value = content,
            onValueChange = {
                content = it
            },
            shape = RoundedCornerShape(20.dp),
            colors = TextFieldDefaults.colors(
                unfocusedContainerColor = Color.Transparent,
                focusedContainerColor = Color.White,
                focusedIndicatorColor = Color.Black,
                unfocusedIndicatorColor = Color.Transparent
            ),
            modifier = Modifier
                .width(400.dp)
                .height(450.dp)
                //.wrapContentHeight()
                .padding(start = 10.dp, end = 10.dp),
            placeholder = {
                Text(text = "Add Content")
            },
            keyboardOptions = KeyboardOptions.Default.copy(
                imeAction = ImeAction.Done
            ),
        )

        Button(
            modifier = Modifier.padding(20.dp),
            onClick = {
                val note = Note(0,title,content)
                addNoteViewModel.addNote(note)
                navController.navigate("note_list_screen")
            }) {
            Text(text = "Add Note")
        }
    }
}