package com.alamin.todo.ui.screens

import android.app.Application
import com.alamin.todo.ui.screens.database.Dao.MyDatabase

class MyApp: Application() {

    override fun onCreate() {
        super.onCreate()
        MyDatabase.init(this)
    }
}