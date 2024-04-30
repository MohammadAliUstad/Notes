package com.seismic.notes.data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName="Note-table")
data class Note(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    @ColumnInfo(name="Note-title")
    var title: String ="",
    @ColumnInfo(name="Note-description")
    var description:String=""
)