package com.android.android_ui_livedata.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.android.android_ui_livedata.R
import com.android.android_ui_livedata.databinding.RecyclerMovieCardBinding
import com.android.android_ui_livedata.databinding.RecyclerTodoRowBinding
import com.android.android_ui_livedata.model.Movie
import com.android.android_ui_livedata.model.Todo

class RecyclerToDoAdapter (val todoList:ArrayList<Todo>): RecyclerView.Adapter<RecyclerToDoAdapter.ToDoHolder>() {

    class ToDoHolder(var view: RecyclerTodoRowBinding):RecyclerView.ViewHolder(view.root){

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ToDoHolder {
        val inflater= LayoutInflater.from(parent.context)
        val view= DataBindingUtil.inflate<RecyclerTodoRowBinding>(inflater, R.layout.recycler_todo_row,parent,false)
        return RecyclerToDoAdapter.ToDoHolder(view)
    }

    override fun onBindViewHolder(holder: ToDoHolder, position: Int) {
        holder.view.todo=todoList[position]
    }

    override fun getItemCount(): Int {
        return todoList.size
    }


}