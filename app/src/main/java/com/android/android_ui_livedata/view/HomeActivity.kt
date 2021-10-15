package com.android.android_ui_livedata.view


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.ContactsContract
import android.text.SpannableStringBuilder
import android.text.Spanned
import android.text.style.ImageSpan
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.LinearLayout
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.view.get
import androidx.databinding.BindingAdapter
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import com.android.android_ui_livedata.R
import com.android.android_ui_livedata.adapter.RecyclerActorAdapter
import com.android.android_ui_livedata.adapter.RecyclerMovieAdapter
import com.android.android_ui_livedata.databinding.ActivityHomeBinding
import com.android.android_ui_livedata.databinding.RecyclerMovieCardBinding
import com.android.android_ui_livedata.model.Actor
import com.android.android_ui_livedata.model.Movie
import com.android.android_ui_livedata.util.Util
import com.google.android.material.bottomnavigation.BottomNavigationView
import android.text.style.UnderlineSpan

import android.text.SpannableString




class HomeActivity : AppCompatActivity() {
    private lateinit var homeActivityBinding:ActivityHomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar!!.hide()
        homeActivityBinding=DataBindingUtil.setContentView(this,R.layout.activity_home)


        createBottomNavBadge()
        initAdapters()

    }



    private fun createBottomNavBadge(){
        val bottomnav= homeActivityBinding.bottomNavigation
        val badge=bottomnav.getOrCreateBadge(R.id.page_4)
        badge.isVisible = true

    }


    private fun initAdapters(){

        val util=Util()

        val movieAdapter=RecyclerMovieAdapter(util.createDummyMovies())
        val actorAdapter=RecyclerActorAdapter(util.createDummyActors())

        homeActivityBinding.apply {
        recyclerMovie.apply {
            layoutManager=LinearLayoutManager(this@HomeActivity,LinearLayoutManager.HORIZONTAL,false)
            adapter=movieAdapter
        }

        recyclerActor.apply {
            layoutManager=LinearLayoutManager(this@HomeActivity,LinearLayoutManager.HORIZONTAL,false)
            adapter=actorAdapter
        }

    }

    }

}

