package com.android.android_ui_livedata.util

import android.graphics.*
import android.widget.ImageView
import androidx.cardview.widget.CardView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.databinding.BindingAdapter
import com.android.android_ui_livedata.R
import com.android.android_ui_livedata.model.Actor
import com.android.android_ui_livedata.model.Movie
import com.google.android.material.bottomnavigation.BottomNavigationView

import android.graphics.drawable.Drawable
import android.util.Log
import android.view.View
import java.lang.ref.WeakReference
import java.util.*
import kotlin.collections.ArrayList


class Util {


     fun createDummyMovies():ArrayList<Movie>{
         val movie1= Movie("ema", R.drawable.poster,"7.3")
         val movie2= Movie("ema2", R.drawable.poster,"7.7")
         val movie3= Movie("ema2", R.drawable.poster,"9.6")
        return arrayListOf(movie1,movie2,movie3)
    }


     fun createDummyActors():ArrayList<Actor>{

        val actor1= Actor("Robert De Niro", R.drawable.actor2)
        val actor2= Actor("Jack Nicholson", R.drawable.actor1)
        val actor3= Actor("Marlon Brando", R.drawable.actor3)
        val actor4= Actor("Brad Pitt", R.drawable.actor2)
        val actor5= Actor("Leonardo Di Caprio", R.drawable.actor1)
        return arrayListOf(actor1,actor2,actor3,actor4,actor5)
    }



}

@BindingAdapter("android:setPosterImg")
fun setPosterImg(view: ImageView, posterId:Int){
    view.setImageResource(posterId)
}

