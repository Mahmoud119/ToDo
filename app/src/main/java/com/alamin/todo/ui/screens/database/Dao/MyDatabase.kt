package com.alamin.todo.ui.screens.database.Dao

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.alamin.todo.ui.screens.model.TodoDm

@Database(entities = [TodoDm::class], version = 1)
abstract class MyDatabase : RoomDatabase() {

   abstract fun getTodoDao(): TodoDao

   companion object{

      private var database : MyDatabase? = null

      fun init(context : Context){
         if (database == null){
            database = Room.databaseBuilder(context,MyDatabase::class.java,"todo_database")
               .fallbackToDestructiveMigration(true)
               .allowMainThreadQueries()
               .build()
         }
      }
      fun getInstance() : MyDatabase {

         return database!!
      }
   }


}


