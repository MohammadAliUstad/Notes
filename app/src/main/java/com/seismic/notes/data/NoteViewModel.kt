package com.seismic.notes.data

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch

class NoteViewModel(
    private val noteRepository: NoteRepository=Graph.NoteRepository
) : ViewModel() {
    var noteTitleState by mutableStateOf("")
    var noteDescriptionState by mutableStateOf("")

    fun onTitleChange(currentTitle: String) {
        noteTitleState=currentTitle
    }
    fun onDescriptionChange(currentDescription: String) {
        noteDescriptionState=currentDescription
    }

    fun addNote(note: Note) {
        viewModelScope.launch(Dispatchers.IO) {
            noteRepository.addNote(note=note)
        }
    }

    fun getNote(id: Int):Flow<Note> {
        return noteRepository.getNote(id)
    }

    lateinit var getAllNotes: Flow<List<Note>>

    init {
        viewModelScope.launch {
            getAllNotes = noteRepository.getAllNotes()
        }
    }

    fun updateNote(note: Note) {
        viewModelScope.launch(Dispatchers.IO) {
            noteRepository.updateNote(note=note)
        }
    }

    fun deleteNote(note: Note) {
        viewModelScope.launch(Dispatchers.IO) {
            noteRepository.deleteNote(note=note)
        }
    }
}