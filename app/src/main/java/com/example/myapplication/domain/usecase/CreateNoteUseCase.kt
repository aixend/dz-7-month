package com.example.myapplication.domain.usecase

import com.example.myapplication.domain.model.Note
import com.example.myapplication.domain.repository.NoteRepository
import javax.inject.Inject

class CreateNoteUseCase @Inject constructor(
    private val noteRepository: NoteRepository
) {
    fun getCreateNote(note:Note) = noteRepository.createNote(note)
}