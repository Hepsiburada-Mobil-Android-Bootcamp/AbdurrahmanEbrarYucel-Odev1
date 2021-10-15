package com.android.android_ui_livedata.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.android.android_ui_livedata.R
import com.android.android_ui_livedata.databinding.ActivityLauncherBinding
import com.android.android_ui_livedata.databinding.ActivityToDoBinding

class LauncherActivity : AppCompatActivity() {

    private lateinit var launchActivityBinding: ActivityLauncherBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initBinding()

    }


    private fun initBinding(){
        launchActivityBinding= DataBindingUtil.setContentView(this,R.layout.activity_launcher)
        launchActivityBinding.launcherActivityReference=this
    }

    fun loginScreenOnClick(){
        startActivity(Intent(this,MainActivity::class.java))
    }

    fun todoScreenOnClick(){
        startActivity(Intent(this,ToDoActivity::class.java))
    }

    fun homeScreenOnClick(){
        startActivity(Intent(this,HomeActivity::class.java))
    }

}