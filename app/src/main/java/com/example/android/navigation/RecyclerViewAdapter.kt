package com.example.myapplication

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
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
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.titleTextView.text = listeData.get(position).title
        holder.descTextView.text = listeData.get(position).description
    }

    interface  ClickListener{
        fun onItemClick(dataModel: DataModel)
    }
}