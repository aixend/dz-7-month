package com.example.myapplication.domain.usecase

import com.example.myapplication.domain.repository.NoteRepository

class GetAllNotesUseCase (
    private val noteRepository: NoteRepository
        ){
    fun getAllNotes() = noteRepository.getAllNotes()
}



