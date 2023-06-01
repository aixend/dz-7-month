package com.example.myapplication.data.repository

import com.example.myapplication.data.local.NoteDao
import com.example.myapplication.data.mappers.toEntity
import com.example.myapplication.data.mappers.toNote
import com.example.myapplication.domain.model.Note
import com.example.myapplication.domain.repository.NoteRepository
import com.example.myapplication.domain.utils.Resource
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn

class NoteRepositoryImpl(
    private val noteDao: NoteDao
) : NoteRepository {

    override fun getAllNotes(): Flow<Resource<List<Note>>> {
        return flow {
            emit(Resource.Loading())
            try {
                val data = noteDao.getAllNotes().map { it.toNote() }
                emit(Resource.Success(data))
            } catch (e: Exception) {
                emit(Resource.Error(e.localizedMessage ?: "unknown error"))
            }
        }.flowOn(Dispatchers.IO)
    }

    override fun createNote(note: Note) {
        noteDao.createNote(note.toEntity())
    }

    override fun updateNote(note: Note) {
        noteDao.updateNote(note.toEntity())
    }

    override fun deleteNote(note: Note) {
        noteDao.deleteNote(note.toEntity())
    }
}