package com.example.noteapp.data.data_source

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.noteapp.domain.model.Note

@Database(entities = [Note::class], version = 2)
abstract class NoteDatabase :RoomDatabase(){

    abstract fun noteDao() : NoteDao
}