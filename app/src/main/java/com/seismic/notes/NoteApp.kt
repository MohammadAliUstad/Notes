package com.seismic.notes

import android.app.Application
import com.seismic.notes.data.Graph

class NoteApp: Application() {
    override fun onCreate() {
        super.onCreate()
        Graph.provide(this)
    }
}