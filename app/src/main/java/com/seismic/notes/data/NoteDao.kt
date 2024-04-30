package com.seismic.notes.data

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import kotlinx.coroutines.flow.Flow

@Dao
abstract class NoteDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    abstract suspend fun addNote(note: Note)

    @Query("Select * from `Note-table` where id=:id")
    abstract fun getNote(id: Int): Flow<Note>

    @Query("Select * from `Note-table`")
    abstract fun getAllNotes(): Flow<List<Note>>

    @Update
    abstract suspend fun updateNote(note: Note)

    @Delete
    abstract suspend fun deleteNote(note: Note)
}