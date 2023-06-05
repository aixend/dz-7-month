package com.example.myapplication.domain.usecase

import com.example.myapplication.domain.repository.NoteRepository
import javax.inject.Inject

class GetAllNotesUseCase @Inject constructor (
    private val noteRepository: NoteRepository
        ){
    fun getAllNotes() = noteRepository.getAllNotes()
}



