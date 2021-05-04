package com.example.hiary.Adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView
import com.example.hiary.Activity.StartActivity
import com.example.hiary.Database.Category
import com.example.hiary.Database.CategoryDB
import com.example.hiary.Holder.AddMenuViewHolder
import com.example.hiary.Holder.MainNotImageViewHolder
import com.example.hiary.R

class AddAdapter(val db: CategoryDB, var items: MutableList<Category>?, var context: Context) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val view: View =
            LayoutInflater.from(parent.context).inflate(R.layout.add_category_type, parent, false)
        return AddMenuViewHolder(view)
    }

    override fun getItemId(position: Int): Long {
        return super.getItemId(position)
    }

    fun getItem(): List<Category>? {
        return items
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        (holder as AddMenuViewHolder).bind(items!!.get(position), position)
        holder.itemView.setOnClickListener {
            val addIntent = Intent(context, StartActivity::class.java)
            addIntent.putExtra("category", items!!.get(position).toString())
            addIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK)
            addIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
            startActivity(context, addIntent, null)
        }
    }

    override fun getItemCount(): Int {
        return 0
    }


}