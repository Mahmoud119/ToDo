package com.alamin.todo.ui.screens.database.Dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.alamin.todo.ui.screens.model.TodoDm


@Dao
interface TodoDao {
    @Update
    fun updateTodo(todo: TodoDm)

    @Insert
    fun addTodo(todo : TodoDm)

    @Delete
    fun deleteTodo(todo : TodoDm)

    @Query ("SELECT * FROM todo ")
    fun getAllTodo() : List<TodoDm>

    @Query ("Select * from todo where date = :date")
    fun getTodoByDate(date : Long) : List<TodoDm>


}