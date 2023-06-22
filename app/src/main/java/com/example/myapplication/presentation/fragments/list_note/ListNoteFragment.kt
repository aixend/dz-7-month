package com.example.myapplication.presentation.fragments.list_note

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import android.widget.Toast
import androidx.core.view.isVisible
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.myapplication.R
import com.example.myapplication.databinding.FragmentListNoteBinding
import com.example.myapplication.domain.model.Note
import com.example.myapplication.presentation.base.BaseFragment
import com.example.myapplication.presentation.fragments.list_note.adapter.ListNoteAdapter
import com.example.myapplication.presentation.utils.UIState
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class ListNoteFragment : BaseFragment(R.layout.fragment_list_note) {
    private val binding by viewBinding(FragmentListNoteBinding::bind)
    private val adapter by lazy { ListNoteAdapter(this::deleteNote, this::updateNote) }
    private val viewModel: ListNoteViewModel by viewModels()
    override fun setupRequests() {
        getAllNotes()
    }

    override fun setupObservers() {
        viewModel.getAllNotesState.collectUIState(
            state = {
                binding.progressBar.isVisible = it is UIState.Loading
            },
            onSuccess = {
                adapter.addList(it)
            }
        )

        viewModel.deleteNoteState.collectUIState(
            state = {
                binding.progressBar.isVisible = it is UIState.Loading
            },
            onSuccess = {
                getAllNotes()
            }
        )
    }

    override fun initialize() {
        binding.rvNotes.layoutManager =
            LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
        binding.rvNotes.adapter = adapter
    }

    private fun deleteNote(note:Note) {
        viewModel.deleteNote(note)
    }

    override fun initClickListeners() {
        binding.btnCreate.setOnClickListener {
            findNavController().navigate(R.id.action_listNoteFragment_to_createNoteFragment)
        }
    }

    private fun getAllNotes() {
        viewModel.getAllNotes()
    }

    private fun updateNote(note:Note) {
        val bundle = Bundle()
        bundle.putSerializable(KEY, note)
        findNavController().navigate(R.id.action_listNoteFragment_to_createNoteFragment, bundle)
    }

    companion object {
        const val KEY = "note"
    }
}