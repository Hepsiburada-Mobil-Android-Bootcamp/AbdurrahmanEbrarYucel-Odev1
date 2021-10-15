package com.android.android_ui_livedata.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.ViewOutlineProvider
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.android.android_ui_livedata.model.Movie
import com.android.android_ui_livedata.R
import com.android.android_ui_livedata.databinding.RecyclerMovieCardBinding
import eightbitlab.com.blurview.BlurView
import eightbitlab.com.blurview.RenderScriptBlur


class RecyclerMovieAdapter(val movieList:ArrayList<Movie>):RecyclerView.Adapter<RecyclerMovieAdapter.MovieHolder>(),HeartClickListener {
    class MovieHolder(var view: RecyclerMovieCardBinding):RecyclerView.ViewHolder(view.root){

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieHolder {
        val inflater=LayoutInflater.from(parent.context)
        val view=DataBindingUtil.inflate<RecyclerMovieCardBinding>(inflater, R.layout.recycler_movie_card,parent,false)

        view.blurView.apply {
            outlineProvider= ViewOutlineProvider.BACKGROUND
            clipToOutline=true
            setupWith(view.root as ViewGroup)
                .setBlurEnabled(true)
                .setBlurAlgorithm(RenderScriptBlur(view.root.context))
                .setBlurRadius(25f)
                .setBlurAutoUpdate(true)
                .setHasFixedTransformationMatrix(true)
        }

        view.blurView2.apply {
            outlineProvider= ViewOutlineProvider.BACKGROUND
            clipToOutline=true
            setupWith(view.root as ViewGroup)
                .setBlurEnabled(true)
                .setBlurAlgorithm(RenderScriptBlur(view.root.context))
                .setBlurRadius(12f)
                .setBlurAutoUpdate(true)
                .setHasFixedTransformationMatrix(true)
        }


        return MovieHolder(view)
    }

    override fun onBindViewHolder(holder: MovieHolder, position: Int) {
        holder.view.movie=movieList[position]
    }

    override fun getItemCount(): Int {
        return movieList.size
    }

    override fun onHeartClicked(view: View) {

    }


}