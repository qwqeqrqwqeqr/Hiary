package com.example.hiary.Holder

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.hiary.Database.Category
import com.example.hiary.R
import kotlinx.android.synthetic.main.add_category_type.view.*

class AddMenuViewHolder(view:View) : RecyclerView.ViewHolder(view) {
    var index: Int?=null
    fun bind(category: Category, position:Int){
        index =position
        itemView.category.setText(category.category)
    }

}