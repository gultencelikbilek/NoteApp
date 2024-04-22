package com.example.noteapp.domain.usecase

import com.example.noteapp.data.repoimpl.NoteRepositoryImpl
import com.example.noteapp.domain.model.Note

class AddNoteUseCase(val repositoryImpl: NoteRepositoryImpl) {

    operator suspend fun invoke(note: Note) = repositoryImpl.addNote(note)
}