package com.example.hiary.Activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Adapter
import android.widget.AdapterView
import android.widget.ArrayAdapter
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.hiary.Adapter.AddAdapter
import com.example.hiary.Adapter.MainAdapter
import com.example.hiary.Database.Category
import com.example.hiary.Database.CategoryDB
import com.example.hiary.R
import kotlinx.android.synthetic.main.activity_add.*
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*

class AddActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add)
        var categoryList : MutableList<Category>? = null
        var categorySwitch: Category?

        var categoryDB = CategoryDB.getInstance(this)!!
        val savedcategoryList = categoryDB.categoryDao().getAll()
        if(savedcategoryList.isNotEmpty()){
            categoryList?.addAll(savedcategoryList)
        }
        addMenuRecyclerView.layoutManager = LinearLayoutManager(this)
        addMenuRecyclerView.adapter = AddAdapter(categoryDB,categoryList,this)

        }
    }
//    fun baseData(categoryList : ArrayList<String>){
//        categoryList.add("선택하세요")
//        categoryList.add("추가")
//    }
//        a.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
//            override fun onItemSelected(
//                parent: AdapterView<*>?,
//                view: View?,
//                position: Int,
//                id: Long
//            ) {
//                if(categoryList.get(position).equals(1)){
//                    val categoryDlg = CategoryPopupActivity(this@AddActivity)
//                    categoryDlg.start()
//                }
//                categorySwitch = categoryList.get(position)
//            }
//            override fun onNothingSelected(parent: AdapterView<*>?) {
//                categorySwitch = null
//            }