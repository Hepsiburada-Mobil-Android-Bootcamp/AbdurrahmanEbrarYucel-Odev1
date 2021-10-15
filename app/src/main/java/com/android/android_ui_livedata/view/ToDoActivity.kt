package com.android.android_ui_livedata.view

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.android.android_ui_livedata.R
import com.android.android_ui_livedata.adapter.RecyclerToDoAdapter
import com.android.android_ui_livedata.databinding.ActivityToDoBinding
import com.android.android_ui_livedata.model.Todo
import com.android.android_ui_livedata.viewmodel.ToDoActivityViewModel


class ToDoActivity : AppCompatActivity() {

    private val model: ToDoActivityViewModel by viewModels()
    private lateinit var todoActivityBinding: ActivityToDoBinding
    val todoList= arrayListOf<Todo>()
    private lateinit var recyclerViewAdapter:RecyclerToDoAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar!!.hide()

        initBinding()
        initAdapter()
        initObserver()
    }

    fun addOnClick(){
        todoList.add(Todo(todoActivityBinding.edittext8.text.toString(),todoActivityBinding.edittext10.text.toString()))
        model.todoList.value = todoList
    }

    private fun initBinding(){
        todoActivityBinding=DataBindingUtil.setContentView(this,R.layout.activity_to_do)
        todoActivityBinding.todoActivityReference=this
    }

    private fun initAdapter(){

        recyclerViewAdapter=RecyclerToDoAdapter(todoList)

        todoActivityBinding.recyclerTodo.apply {
            adapter=recyclerViewAdapter
            layoutManager =LinearLayoutManager(this@ToDoActivity, LinearLayoutManager.VERTICAL, false)
            val mDividerItemDecoration = DividerItemDecoration(this.getContext(), LinearLayoutManager.VERTICAL)
            this.addItemDecoration(mDividerItemDecoration)
        }

    }


    private fun initObserver(){
        val todoObserver= Observer<ArrayList<Todo>> {
        todoActivityBinding.recyclerTodo.adapter=RecyclerToDoAdapter(todoList)
        }
        model.todoList.observe(this,todoObserver)

    }





}