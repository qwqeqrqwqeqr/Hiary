package com.example.hiary.Adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.hiary.Database.Content.Content
import com.example.hiary.R
import java.lang.RuntimeException

class MainAdapter(val contents: MutableList<Content>, val context: Context):RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val view: View?
        return when(viewType){
            Content.TEXT_TYPE->{
                view=LayoutInflater.from(parent.context).inflate(R.layout.main_not_image_type,parent,false)
                NotImageViewHolder(view)
            }
            Content.IMAGE_TYPE->{
                view=LayoutInflater.from(parent.context).inflate(R.layout.main_image_type,parent,false)
                ImageViewHolder(view)
            }
            else-> throw  RuntimeException("unknown view type error")
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
       val obj = contents[position]
        when (obj.type){
            Content.TEXT_TYPE ->{
                (holder as NotImageViewHolder).title.text = obj.title
                holder.contents.text =obj.contents
                holder.date.text = obj.date.toString() // 수정예정
                holder.time.text = obj.time// 수정예정
            }

            Content.IMAGE_TYPE -> {
                    (holder as ImageViewHolder).title.text = obj.title
                    holder.contents.text =obj.contents
                    holder.date.text= obj.date.toString()// 수정예정
                    holder.time.text=obj.time // 수정예정
                    holder.image.setImageResource(obj.image)
            }
        }
    }
    override fun getItemCount(): Int {
        return  contents.size
    }

    override fun getItemViewType(position: Int): Int {
        return contents[position].type
    }

    inner  class ImageViewHolder(itemView: View):RecyclerView.ViewHolder(itemView){
        var date : TextView = itemView.findViewById(R.id.date)
        var time : TextView = itemView.findViewById(R.id.timer)
        var title : TextView = itemView.findViewById(R.id.title)
        var contents: TextView = itemView.findViewById(R.id.contents)
        var image: ImageView = itemView.findViewById(R.id.image)
    }
    inner class NotImageViewHolder(itemView: View):RecyclerView.ViewHolder(itemView){
        var date: TextView = itemView.findViewById(R.id.date)
        var time: TextView = itemView.findViewById(R.id.timer)
        var title: TextView = itemView.findViewById(R.id.title)
        var contents: TextView = itemView.findViewById(R.id.contents)
    }
}
