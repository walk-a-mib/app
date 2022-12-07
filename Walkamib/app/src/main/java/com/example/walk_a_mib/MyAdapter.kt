package com.example.walk_a_mib

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class MyAdapter(private val routeList : ArrayList<Route>) :
    RecyclerView.Adapter<MyAdapter.MyViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.list_item, parent, false)
        return MyViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val currentItem = routeList[position]
        holder.titleSvg.setImageResource(currentItem.titleSvg)
        holder.textView.text = currentItem.description
    }

    override fun getItemCount(): Int {
        return routeList.size
    }

    class MyViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView) {
        val titleSvg : ImageView = itemView.findViewById(R.id.title_svg)
        val textView : TextView = itemView.findViewById(R.id.description)

    }

}