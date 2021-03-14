package com.example.hiary.Holder

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.hiary.R

class WriteMenuViewHolder  (view: View) : RecyclerView.ViewHolder(view){
    //var category : String ,var time : String, var state : Boolean
    val category : TextView = view.findViewById(R.id.category)
    val time : TextView = view.findViewById(R.id.timer)
    val state : TextView = view.findViewById(R.id.state)

}