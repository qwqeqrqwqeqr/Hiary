package com.example.hiary.Adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView
import com.example.hiary.Activity.StartActivity
import com.example.hiary.Database.Category
import com.example.hiary.Holder.AddMenuViewHolder
import com.example.hiary.Holder.MainNotImageViewHolder
import com.example.hiary.R
import kotlinx.android.synthetic.main.add_category_type.view.*

class AddAdapter(var category: MutableList<Category>, val context: Context) :
    RecyclerView.Adapter<AddAdapter.Holder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder{
        val view = LayoutInflater.from(parent.context).inflate(R.layout.add_category_type, parent, false)
        return Holder(view)
    }

    override fun getItemId(position: Int): Long {
        return super.getItemId(position)
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
        holder.bind(category[position])
//        holder.itemView.setOnClickListener {
//            val addIntent = Intent(context, StartActivity::class.java)
//            addIntent.putExtra("category", category.get(position).toString())
//            addIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK)
//            addIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
//            startActivity(context, addIntent, null)
//        }
    }
    override fun getItemCount(): Int {
        return category.size
    }
    inner class  Holder(itemView:View): RecyclerView.ViewHolder(itemView){
        fun bind(category: Category){
            itemView.category.text = category.category
        }
    }


}