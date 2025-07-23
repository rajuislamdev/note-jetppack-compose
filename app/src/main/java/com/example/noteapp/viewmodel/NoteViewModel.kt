package com.example.noteapp.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import com.example.noteapp.model.Note

class NoteViewModel(private val savedStateHandle: SavedStateHandle) : ViewModel() {

    companion object {
        const val NOTE_KEY = "note"
    }

    // LiveData backed by SavedStateHandle - automatically saved/restored
    val selectedNote: LiveData<Note?> = savedStateHandle.getLiveData(NOTE_KEY)

    // Save note to SavedStateHandle
    fun saveNote(note: Note) {
        savedStateHandle[NOTE_KEY] = note
    }

    // Remove note from SavedStateHandle
    fun removeNote() {
        savedStateHandle.remove<Note>(NOTE_KEY)
    }


}