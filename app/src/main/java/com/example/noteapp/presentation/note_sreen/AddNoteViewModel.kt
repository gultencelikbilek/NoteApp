package com.example.noteapp.presentation.note_sreen

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.noteapp.domain.model.Note
import com.example.noteapp.domain.usecase.AddNoteUseCase
import com.example.noteapp.presentation.note_list_screen.NoteState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AddNoteViewModel @Inject constructor(
    val addNoteUseCase: AddNoteUseCase
): ViewModel() {

    private val _noteState = mutableStateOf(NoteState())
    val noteState : State<NoteState> = _noteState

     fun addNote(note: Note){
        viewModelScope.launch {
            val addNoteResponse = addNoteUseCase.invoke(note)
            _noteState.value = _noteState.value.copy(
                data = _noteState.value.data
            )
        }
    }
}

