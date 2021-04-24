package com.example.hiary.Adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.hiary.DataClass.SubContents
import com.example.hiary.Holder.WriteMenuViewHolder
import com.example.hiary.R

class WriteMenuAdapter (val list: MutableList<SubContents>, val context: Context):
    RecyclerView.Adapter<ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return WriteMenuViewHolder(LayoutInflater.from(context).
        inflate(R.layout.write_menu_type,parent,false))
}

override fun onBindViewHolder(holder: ViewHolder, position: Int) {
    (holder as WriteMenuViewHolder).category.text  = list[position].category
    holder.time.text  = list[position].time
    holder.state.text = list[position].state
}

override fun getItemCount(): Int {
    return list.size;
}
}