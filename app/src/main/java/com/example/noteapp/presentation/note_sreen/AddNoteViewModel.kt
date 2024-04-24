package com.example.noteapp.presentation.note_sreen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.noteapp.domain.model.Note
import com.example.noteapp.domain.usecase.AddNoteUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AddNoteViewModel @Inject constructor(
    val addNoteUseCase: AddNoteUseCase
): ViewModel() {
     fun addNote(note: Note){
        viewModelScope.launch {
            val addNoteResponse = addNoteUseCase.invoke(note)
        }
    }
}