package com.example.noteapp.data.repoimpl

import android.content.Context
import com.example.noteapp.data.di.AppModule
import com.example.noteapp.domain.model.Note
import com.example.noteapp.domain.repository.NoteRepository

class NoteRepositoryImpl(val app:Context) :NoteRepository {
    override suspend fun addNote(note: Note) {
        AppModule.provideRoom(app).noteDao().addNote(note)
    }
}