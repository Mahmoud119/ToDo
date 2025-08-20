package com.alamin.todo.ui.screens.screens.main

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.alamin.todo.R
import com.alamin.todo.databinding.ActivityMainBinding
import com.alamin.todo.ui.screens.screens.add_todo.AddToDoBottomSheet
import com.alamin.todo.ui.screens.screens.main.fragments.settings.SettingsFragment
import com.alamin.todo.ui.screens.screens.main.fragments.settings.TodoListFragment


class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
//        Room.databaseBuilder(this, MyDatabase::class.java, "todo_database")
//            .build()

        setContentView(binding.root)
        initListeners()
        showFragment(todoListFragment)
    }

    val todoListFragment = TodoListFragment()
    private fun initListeners() {
        binding.fab.setOnClickListener {
            val addTodoFragment = AddToDoBottomSheet{
                todoListFragment.refreshTodos()
            }
            addTodoFragment.show(supportFragmentManager, null)
        }
        binding.bottomNavBar.setOnItemSelectedListener {
            if (it.itemId == R.id.ic_list) {
                showFragment(todoListFragment)
            } else if (it.itemId == R.id.ic_settings) {
                showFragment(SettingsFragment())
            }

            return@setOnItemSelectedListener true
        }
    }

    private fun showFragment(Fragment: Fragment) {
            supportFragmentManager.beginTransaction().
            replace(R.id.fragment_container, Fragment)
                .commit()
    }
}