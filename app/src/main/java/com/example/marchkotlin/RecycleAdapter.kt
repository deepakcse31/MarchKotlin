package com.example.marchkotlin

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class RecycleAdapter(private val fruitlist : List<Fruit>) : RecyclerView.Adapter<RecycleAdapter.RecyclerViewHolder>() {

    class RecyclerViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView){
        val ivImage = itemView.findViewById<ImageView>(R.id.ivimage)
        val tvName = itemView.findViewById<TextView>(R.id.tvName)
        val tvDescription = itemView.findViewById<TextView>(R.id.tvDescription)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.rv_list,parent,false)
        return RecyclerViewHolder(view)
    }

    override fun onBindViewHolder(holder: RecyclerViewHolder, position: Int) {
        val fruit = fruitlist[position]
        holder.tvName.text = fruit.name
        holder.tvDescription.text = fruit.description
        holder.ivImage.setImageResource(fruit.image)
    }

    override fun getItemCount(): Int {
        return fruitlist.size
    }
}