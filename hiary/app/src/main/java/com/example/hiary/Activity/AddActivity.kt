package com.example.hiary.Activity

import android.content.Intent
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
        var categoryDB = CategoryDB.getInstance(this)!!

        val savedcategoryList = categoryDB.categoryDao().getAll()
        if(savedcategoryList.isNotEmpty()){
            categoryList?.addAll(savedcategoryList)
        }
        val adapter = AddAdapter(categoryDB,categoryList,this)
        adapter.setItemClickListener(object : AddAdapter.OnItemClickListener{
            override fun onClick(view: View, position: Int) {
                val item = categoryList?.get(position)
                val startIntent = Intent(this, StartActivity::class.java)
            }
        })
        addMenuRecyclerView.layoutManager = LinearLayoutManager(this)
        addMenuRecyclerView.adapter = adapter
        initClickBtn()
    }
    fun initClickBtn(){
        addBackBtn.setOnClickListener {
            val finishIntent = Intent(this, MainActivity::class.java)
            finishIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK)
            finishIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
            startActivity(finishIntent)
        }
    }
}
