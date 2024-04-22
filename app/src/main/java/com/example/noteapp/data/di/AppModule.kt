package com.example.noteapp.data.di

import android.content.Context
import androidx.room.Room
import com.example.noteapp.data.data_source.NoteDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideRoom(@ApplicationContext app: Context) =
        Room.databaseBuilder(app, NoteDatabase::class.java, "note_db").build()

}