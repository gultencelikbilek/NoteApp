package com.example.noteapp.domain.usecase

import android.util.Log
import com.example.noteapp.data.repoimpl.NoteRepositoryImpl
import com.example.noteapp.domain.model.Note
import com.example.noteapp.presentation.DatabaseResult
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class AllNoteListUseCase @Inject constructor(private val repositoryImpl: NoteRepositoryImpl) {

    operator suspend fun invoke() : Flow<List<Note>> = flow{
        try {
            emit(repositoryImpl.allNote())//emit() ile paylaşım yaparım
        }catch (e:Exception){
            Log.d("allnoteusecase:",e.message.toString())
    }
    }
}