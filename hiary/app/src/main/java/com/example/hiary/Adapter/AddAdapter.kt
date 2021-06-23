package com.example.hiary.Adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.hiary.Database.Category
import com.example.hiary.Database.CategoryDB
import com.example.hiary.Popup.CategoryPopupActivity
import com.example.hiary.Popup.DeleteCategoryPopupActivity
import com.example.hiary.R
import kotlinx.android.synthetic.main.add_category_type.view.*

class AddAdapter(var categoryDB : CategoryDB, var category: MutableList<Category>, val context: Context, val itemClick:(Category) ->Unit):
    RecyclerView.Adapter<AddAdapter.Holder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.add_category_type, parent, false)
        return Holder(view,itemClick)
    }

    override fun getItemId(position: Int): Long {
        return super.getItemId(position)
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
        holder.bind(category[position])
    }

    override fun getItemCount(): Int {
        return category.size
    }

    inner class  Holder(itemView:View, itemClick:(Category) ->Unit) : RecyclerView.ViewHolder(itemView) {
        fun bind(category: Category) {
            itemView.category.text = category.category
            itemView.setOnClickListener() { itemClick(category) }
        }
    }
    //        itemView.setOnLongClickListener {
//            var positionTmp = category[position]
//            var deleteCategoryPopupActivity = DeleteCategoryPopupActivity(context)
//            deleteCategoryPopupActivity.start()
//            deleteCategoryPopupActivity.setOnCLickedListenr(object : DeleteCategoryPopupActivity.ButtonClickLisener {
//                override fun onClicked() {
//                    categoryDB.categoryDao().delete(positionTmp)
//                    category.clear()
//                    var tempList = categoryDB.categoryDao().getAll()
//                    category.addAll(tempList)
//
//                }
//            })
//        }
}