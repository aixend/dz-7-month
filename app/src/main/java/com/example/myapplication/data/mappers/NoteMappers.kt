package com.example.myapplication.data.mappers

import com.example.myapplication.data.model.NoteEntity
import com.example.myapplication.domain.model.Note

fun Note.toEntity() = NoteEntity(this.id,title,description)
fun NoteEntity.toNote() = Note(this.id,title,description)