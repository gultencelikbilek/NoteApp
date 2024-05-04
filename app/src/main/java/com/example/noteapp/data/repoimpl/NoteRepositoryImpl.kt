package com.example.noteapp.data.repoimpl

import android.content.Context
import com.example.noteapp.data.di.AppModule
import com.example.noteapp.domain.model.Note
import com.example.noteapp.domain.repository.NoteRepository
import com.example.noteapp.presentation.DatabaseResult
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject

class NoteRepositoryImpl @Inject constructor(@ApplicationContext  val app: Context) :NoteRepository {
    override suspend fun addNote(note: Note) {
        AppModule.provideRoom(app).noteDao().addNote(note)
    }

     override suspend fun allNote(): List<Note> {
         return AppModule.provideRoom(app).noteDao().allNote()
     }
}