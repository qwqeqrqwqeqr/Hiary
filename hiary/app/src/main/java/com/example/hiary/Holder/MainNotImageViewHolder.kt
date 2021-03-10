package com.example.hiary.Holder

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.hiary.R
import kotlinx.android.synthetic.main.activity_main.view.*

class MainNotImageViewHolder (view: View) : RecyclerView.ViewHolder(view){
    val Date: TextView = view.findViewById(R.id.Date)
    val Title: TextView = view.findViewById(R.id.Title)
    val Contents: TextView = view.findViewById(R.id.Contents)
    val Timer: TextView = view.findViewById(R.id.Timer)
}