package com.example.noteapp.domain.repository

import com.example.noteapp.domain.model.Note
import com.example.noteapp.presentation.DatabaseResult

interface NoteRepository {

    suspend fun addNote(note:Note)

    suspend fun allNote() : List<Note>
}