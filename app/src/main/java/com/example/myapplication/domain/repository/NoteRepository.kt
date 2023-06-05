package com.example.myapplication.domain.repository

import com.example.myapplication.domain.model.Note
import com.example.myapplication.domain.utils.Resource
import kotlinx.coroutines.flow.Flow

interface NoteRepository {
    fun getAllNotes(): Flow<Resource<List<Note>>>

    fun createNote(note: Note): Flow<Resource<Unit>>

    fun updateNote(note: Note): Flow<Resource<Unit>>

    fun deleteNote(note: Note): Flow<Resource<Unit>>
}