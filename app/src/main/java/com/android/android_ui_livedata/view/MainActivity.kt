package com.android.android_ui_livedata.view


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.android.android_ui_livedata.R


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportActionBar!!.hide()
    }


}