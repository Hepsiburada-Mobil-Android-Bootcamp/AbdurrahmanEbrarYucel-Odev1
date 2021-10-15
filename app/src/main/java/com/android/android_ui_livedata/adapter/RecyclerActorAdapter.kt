package com.android.android_ui_livedata.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.android.android_ui_livedata.R
import com.android.android_ui_livedata.databinding.RecyclerActorCardBinding
import com.android.android_ui_livedata.databinding.RecyclerMovieCardBinding
import com.android.android_ui_livedata.model.Actor
import com.android.android_ui_livedata.model.Movie

class RecyclerActorAdapter(val actorList:ArrayList<Actor>): RecyclerView.Adapter<RecyclerActorAdapter.ActorHolder>() {
    class ActorHolder(var view: RecyclerActorCardBinding):RecyclerView.ViewHolder(view.root){

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ActorHolder {
        val inflater= LayoutInflater.from(parent.context)
        val view= DataBindingUtil.inflate<RecyclerActorCardBinding>(inflater, R.layout.recycler_actor_card,parent,false)
        return RecyclerActorAdapter.ActorHolder(view)
    }

    override fun onBindViewHolder(holder: ActorHolder, position: Int) {
        holder.view.actor=actorList[position]
    }

    override fun getItemCount(): Int {
        return actorList.size
    }
}