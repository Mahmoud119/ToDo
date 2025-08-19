package com.alamin.todo.ui.screens.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "todo")
data class TodoDm(
    @PrimaryKey(autoGenerate = true)
    val id : Int,
    @ColumnInfo(name = "title")
    val title: String,
    @ColumnInfo(name = "description")
    val description: String,
    @ColumnInfo (name = "date")
    val date: Long,
    @ColumnInfo(name = "isdone")
    val isdone : Boolean
) {
}