package com.example.myapplication

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.android.navigation.AboutFragment
import com.example.android.navigation.R

class RecyclerViewAdapter(val listeData: List<DataModel>, val clickListener:ClickListener) : RecyclerView.Adapter<RecyclerViewAdapter.MyViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerViewAdapter.MyViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.recycle_row, parent,false)
        return MyViewHolder(view)
    }

    override fun getItemCount(): Int {
        return  listeData.size
    }

    class MyViewHolder(view: View): RecyclerView.ViewHolder(view){
        var titleTextView: TextView = view.findViewById(R.id.titleTextView)
        var descTextView: TextView = view.findViewById(R.id.descTextView)
        var imageView: ImageView = view.findViewById(R.id.imageView)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.titleTextView.text = listeData.get(position).title
        holder.descTextView.text = listeData.get(position).description

        holder.imageView.setImageResource(R.drawable.mars)

        val name = listeData.get(position).title

        val drawableResource = when (name) {
            "Mars" -> R.drawable.mars
            "Mercure" -> R.drawable.mercure
            "Jupiter" -> R.drawable.juiter
            "Terre" -> R.drawable.terre
            "Uranus" -> R.drawable.uranus
            "Venus" -> R.drawable.venus
            "Terre" -> R.drawable.terre
            "Neptune" -> R.drawable.neptune
            "Saturne" -> R.drawable.saturne
            "Pluton" -> R.drawable.pluton

            else -> R.drawable.noimage
        }

        holder.imageView.setImageResource(drawableResource)
    }


    interface  ClickListener{
        fun onItemClick(dataModel: DataModel)
    }
}