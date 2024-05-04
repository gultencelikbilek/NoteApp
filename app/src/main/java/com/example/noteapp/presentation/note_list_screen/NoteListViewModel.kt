package com.example.noteapp.presentation.note_list_screen

import android.util.Log
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.noteapp.domain.model.Note
import com.example.noteapp.domain.usecase.AllNoteListUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class NoteListViewModel @Inject constructor(
    private val allNoteListUseCase: AllNoteListUseCase
): ViewModel(){

    private val _noteResponse : MutableState<NoteState> = mutableStateOf(NoteState())
    val noteResponse : State<NoteState> = _noteResponse

    fun getAllNotes(){
        viewModelScope.launch {
             allNoteListUseCase.invoke().collect(){
                    _noteResponse.value.data
                 Log.d("notelistviewmodel:",_noteResponse.value.data.toString())
            }
        }
    }
}

data class NoteState(
    val data : List<Note> = emptyList(),
)