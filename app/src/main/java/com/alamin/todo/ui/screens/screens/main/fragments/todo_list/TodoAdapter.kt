package com.alamin.todo.ui.screens.screens.main.fragments.todo_list

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.alamin.todo.databinding.ItemTodoBinding
import com.alamin.todo.ui.screens.model.TodoDm

class TodoAdapter(var todos : List<TodoDm>) : RecyclerView.Adapter<TodoAdapter.TodoViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TodoAdapter.TodoViewHolder {
        val binding = ItemTodoBinding.inflate(LayoutInflater.from(parent.context),parent,false)

        return TodoViewHolder(binding)
    }

    override fun onBindViewHolder(holder: TodoAdapter.TodoViewHolder, position: Int) {
        val todo = todos[position]
        holder.binding.TaskNameTv.text = todo.title
        holder.binding.taskTimeTv.text = todo.description
        holder.binding.root.setOnClickListener {
            itemClickListener?.onItemClick(todo)
        }
        holder.binding.checkImgv.setOnClickListener {
            itemClickListener?.onDoneClick(todo)
        }

    }

    override fun getItemCount(): Int = todos.size

    @SuppressLint("NotifyDataSetChanged")
    fun submitList(newtodos : List<TodoDm>){
        todos=newtodos
        notifyDataSetChanged()

    }

    var itemClickListener : ItemClickListener? = null
    interface ItemClickListener {
        fun onItemClick(todo: TodoDm)
        fun onDoneClick(todo : TodoDm)

    }
    class TodoViewHolder(val binding : ItemTodoBinding) : RecyclerView.ViewHolder(binding.root) {

    }
}