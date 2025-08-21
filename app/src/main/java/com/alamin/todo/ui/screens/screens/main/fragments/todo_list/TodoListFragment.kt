package com.alamin.todo.ui.screens.screens.main.fragments.settings


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.alamin.todo.databinding.FragmentTodoListBinding
import com.alamin.todo.ui.screens.database.Dao.MyDatabase
import com.alamin.todo.ui.screens.model.TodoDm
import com.alamin.todo.ui.screens.screens.main.fragments.todo_list.TodoAdapter
import java.util.Calendar


class TodoListFragment : Fragment() {

     var adapter = TodoAdapter(emptyList())

    lateinit var binding: FragmentTodoListBinding
    var selectedDate = Calendar.getInstance()
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentTodoListBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initTodosRecycler()
        refreshTodos()
    }

     fun refreshTodos() {
        val todos = MyDatabase.getInstance().getTodoDao().getAllTodo()
        adapter.submitList(todos)

    }

    private fun initTodosRecycler() {
        adapter.itemClickListener= object : TodoAdapter.ItemClickListener{
            override fun onItemClick(todo: TodoDm) {}
            override fun onDoneClick(todo: TodoDm) {}
            override fun onDeleteClick(todo: TodoDm) {
                MyDatabase.getInstance().getTodoDao().deleteTodo(todo)
                refreshTodos()
            }
        }
        binding.todosRecycler.adapter = adapter
    //    adapter.todos =listOf(TodoDm("play basketball","today",123,false),TodoDm("Play Football","today",124,false),TodoDm("Go To cinema"," tomorrow",125,false),TodoDm("go to gym"," today",126,false))

    }


}
