package com.example.noteapp.domain.usecase

import com.example.noteapp.data.repoimpl.NoteRepositoryImpl
import com.example.noteapp.domain.model.Note
import javax.inject.Inject

class AddNoteUseCase @Inject constructor(val repositoryImpl: NoteRepositoryImpl) {

    operator suspend fun invoke(note: Note) = repositoryImpl.addNote(note)
}