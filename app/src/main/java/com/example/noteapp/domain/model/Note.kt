package com.example.noteapp.domain.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "note")
data class Note(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val noteTitle: String ="",
    val noteContent : String =""
)
