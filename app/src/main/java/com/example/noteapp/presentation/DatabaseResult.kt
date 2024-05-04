package com.example.noteapp.presentation

sealed class DatabaseResult<out T> {
    data class Succes<T>(val data :T):DatabaseResult<T>()
    data class Error<T>(val message : String): DatabaseResult<T>()
    data class Loading<T>(var isLoading : Boolean= false) : DatabaseResult<T>()
}