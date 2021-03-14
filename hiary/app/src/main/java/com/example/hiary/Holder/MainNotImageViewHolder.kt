package com.example.hiary.Holder

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.hiary.R

class MainNotImageViewHolder (view: View) : RecyclerView.ViewHolder(view){
    val date: TextView = view.findViewById(R.id.date)
    val title: TextView = view.findViewById(R.id.title)
    val contents: TextView = view.findViewById(R.id.contents)
    val time: TextView = view.findViewById(R.id.timer)
}