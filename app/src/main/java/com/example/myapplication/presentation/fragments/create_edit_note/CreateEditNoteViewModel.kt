package com.example.myapplication.presentation.fragments.create_edit_note

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.myapplication.domain.model.Note
import com.example.myapplication.domain.usecase.CreateNoteUseCase
import com.example.myapplication.domain.usecase.UpdateNoteUseCase
import com.example.myapplication.domain.utils.Resource
import com.example.myapplication.presentation.base.BaseViewModel
import com.example.myapplication.presentation.utils.UIState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject
@HiltViewModel
class CreateEditNoteViewModel @Inject constructor(
    private val createNoteUseCase: CreateNoteUseCase,
    private val updateNoteUseCase: UpdateNoteUseCase
) : BaseViewModel() {

    private val _createNoteState = MutableStateFlow<UIState<Unit>>(UIState.Empty())
    val createNoteState = _createNoteState.asStateFlow()

    private val _updateNoteState = MutableStateFlow<UIState<Unit>>(UIState.Empty())
    val updateNoteState = _updateNoteState.asStateFlow()

    fun createNote(note: Note) {
        createNoteUseCase.getCreateNote(note).collectData(_createNoteState)
    }

    fun updateNote(note: Note) {
        updateNoteUseCase.updateNote(note).collectData(_updateNoteState)
    }
}