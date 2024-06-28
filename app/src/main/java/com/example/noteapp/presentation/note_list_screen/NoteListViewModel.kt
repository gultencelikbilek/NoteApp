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
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class NoteListViewModel @Inject constructor(
    private val allNoteListUseCase: AllNoteListUseCase
): ViewModel(){

    private val _noteResponse : MutableState<NoteState> = mutableStateOf(NoteState())
    val noteResponse : State<NoteState> = _noteResponse

    fun getAllNotes() {
        viewModelScope.launch {
            try {
                val notes = allNoteListUseCase.invoke()
                _noteResponse.value = NoteState(data = notes)
            } catch (e: Exception) {
                // Hata işlemleri
                Log.e("NoteListViewModel", "Hata: ${e.message}")
            }
        }
    }
}
data class NoteState(
    val data : Flow<List<Note>> = flowOf(emptyList())
)