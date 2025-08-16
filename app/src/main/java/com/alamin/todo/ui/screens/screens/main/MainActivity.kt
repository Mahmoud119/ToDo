package com.alamin.todo.ui.screens.screens.main

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.alamin.todo.databinding.ActivityMainBinding
import com.alamin.todo.ui.screens.screens.add_todo.AddToDoBottomSheet


class MainActivity : AppCompatActivity() {
    lateinit var  binding : ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initListeners()
    }

    private fun initListeners() {
        binding.fab.setOnClickListener {
            val addTodoFragment = AddToDoBottomSheet()
            addTodoFragment.show(supportFragmentManager,null)
        }
    }
}