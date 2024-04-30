package com.seismic.notes.data

import android.content.Context
import androidx.room.Room

object Graph {
    private lateinit var database: NoteDatabase

    fun provide(context: Context) {
        database = Room.databaseBuilder(context, NoteDatabase::class.java, "Notes.db").build()
    }

    val NoteRepository by lazy {
        NoteRepository(noteDao = database.noteDao())
    }
}