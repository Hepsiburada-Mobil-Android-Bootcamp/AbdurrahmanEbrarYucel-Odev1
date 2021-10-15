package com.android.android_ui_livedata.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.android.android_ui_livedata.model.Todo

class ToDoActivityViewModel:ViewModel() {
    //val todoList=MutableLiveData<ArrayList<Todo>>(arrayListOf())

    val todoList: MutableLiveData<ArrayList<Todo>> by lazy {
        MutableLiveData<ArrayList<Todo>>(arrayListOf())
    }

}