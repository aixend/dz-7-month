package com.example.myapplication.domain.usecase

import com.example.myapplication.domain.model.Note
import com.example.myapplication.domain.repository.NoteRepository

class UpdateNoteUseCase(
    private val noteRepository: NoteRepository
) {
    fun updateNote(note: Note) = noteRepository.updateNote(note)
}