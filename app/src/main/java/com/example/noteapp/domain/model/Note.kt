package com.example.noteapp.domain.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "note")
data class Note(
    @PrimaryKey val id: Int,
    val noteTitle: String,
    val noteContent : String
)
