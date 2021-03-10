package com.example.hiary.Adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.hiary.Data.MainContents
import com.example.hiary.Holder.MainImageViewHolder
import com.example.hiary.Holder.MainNotImageViewHolder
import com.example.hiary.R
import java.lang.RuntimeException

class MainAdapter(val list: MutableList<MainContents>, val context: Context):RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val view: View?
        return when(viewType){
            MainContents.TEXT_TYPE->{
                view=LayoutInflater.from(parent.context).inflate(R.layout.main_not_image_type,parent,false)
                MainNotImageViewHolder(view)
            }
            MainContents.IMAIGE_TYPE->{
                view=LayoutInflater.from(parent.context).inflate(R.layout.main_image_type,parent,false)
                MainImageViewHolder(view)
            }
            else-> throw  RuntimeException("unknown view type error")
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
       val obj = list[position]
        when (obj.type){

        }
    }
    override fun getItemCount(): Int {
        return  list.size
    }

    override fun getItemViewType(position: Int): Int {
        return list[position].type
    }
}
