package com.example.walk_a_mib.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.walk_a_mib.R
import com.example.walk_a_mib.Route

class RouteAdapter(private val routeList : MutableList<Route>) :
    RecyclerView.Adapter<RouteAdapter.MyViewHolder>() {

    inner class MyViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView) {
        val titleSvg : ImageView
        val textViewDescription : TextView
        val textViewDistance : TextView

        init {
            titleSvg = itemView.findViewById(R.id.title_svg)
            textViewDescription = itemView.findViewById(R.id.description)
            textViewDistance = itemView.findViewById(R.id.distance)
        }

        fun bind(route: Route) {
            this.titleSvg.setImageResource(route.titleSvg)
            this.textViewDescription.text = route.description
            this.textViewDistance.text = route.distance
        }

        // metodo richiamato quando l'utente raggiunge un checkpoint
        fun checkpointReached() {
            if(routeList.size > 0) {
                routeList.removeAt(0)
                notifyItemRemoved(0)
            }
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