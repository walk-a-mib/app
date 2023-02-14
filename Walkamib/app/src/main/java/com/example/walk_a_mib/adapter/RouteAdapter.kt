package com.example.walk_a_mib.adapter

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.core.os.bundleOf
import androidx.lifecycle.MutableLiveData
import androidx.recyclerview.widget.RecyclerView
import com.example.walk_a_mib.R
import com.example.walk_a_mib.Route
import com.example.walk_a_mib.ui.NavigationFragment

class RouteAdapter(private val routeList : MutableList<Route>) :
    RecyclerView.Adapter<RouteAdapter.MyViewHolder>() {

    var selected_position = 0 // You have to set this globally

    inner class MyViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView), View.OnClickListener {
        val titleSvg : ImageView
        val textViewDescription : TextView
        val textViewDistance : TextView


        init {
            titleSvg = itemView.findViewById(R.id.title_svg)
            textViewDescription = itemView.findViewById(R.id.description)
            textViewDistance = itemView.findViewById(R.id.distance)
            itemView.setOnClickListener(this)
        }

        override fun onClick(v: View?) {
            // Below line is just like a safety check, because sometimes holder could be null,
            // in that case, getAdapterPosition() will return RecyclerView.NO_POSITION
            if (adapterPosition == RecyclerView.NO_POSITION) return

            // Updating old as well as new positions
            notifyItemChanged(selected_position)
            selected_position = adapterPosition
            notifyItemChanged(selected_position)

            // Do your another stuff for your onClick


            NavigationFragment.pos.postValue(selected_position)
        }

        fun bind(route: Route) {
            this.titleSvg.setImageResource(route.titleSvg)
            this.textViewDescription.text = route.description
            this.textViewDistance.text = route.distance
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(
            R.layout.list_item, parent, false)

        return MyViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val currentItem = routeList[position]
        holder.bind(currentItem)
    }

    override fun getItemCount(): Int {
        return routeList.size
    }
}