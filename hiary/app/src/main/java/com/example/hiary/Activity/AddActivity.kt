package com.example.hiary.Activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.AdapterView
import android.widget.ArrayAdapter
import androidx.appcompat.app.AlertDialog
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.hiary.Adapter.AddAdapter
import com.example.hiary.Adapter.MainAdapter
import com.example.hiary.Database.Category
import com.example.hiary.Database.CategoryDB
import com.example.hiary.R
import kotlinx.android.synthetic.main.activity_add.*
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.add_category_type.*
import java.util.*
import kotlin.collections.ArrayList
import kotlin.collections.MutableList as MutableList

class AddActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add)
        var categoryList : MutableList<Category> = mutableListOf()
        var categoryDB = CategoryDB.getInstance(this)!!
        val savedcategoryList = categoryDB.categoryDao().getAll()
        if(savedcategoryList.isNotEmpty()){
            categoryList.addAll(savedcategoryList)
        }


        val adapter = AddAdapter(categoryList,this)
        val layoutmanager = LinearLayoutManager(this)
        addMenuRecyclerView.adapter = adapter
        addMenuRecyclerView.layoutManager = layoutmanager
        addMenuRecyclerView.setHasFixedSize(true)
//        initBackBtn()
        Log.d("find","불러온 사이즈"+savedcategoryList.size.toString())
        Log.d("find","카테고리 첫번째"+categoryList.get(0).category)
        Log.d("find","카테고리 첫번째"+categoryList.get(1).category)
        Log.d("find","카테고리 첫번째"+categoryList.get(2).category)
        Log.d("find","카테고리 첫번째"+categoryList.get(3).category)
        Log.d("find","카테고리 첫번째"+categoryList.get(4).category)
        Log.d("find","카테고리 첫번째"+categoryList.get(5).category)
        Log.d("find","카테고리 첫번째"+categoryList.get(6).category)

        addCategoryBtn.setOnClickListener {
            val categoryPopupActivity = CategoryPopupActivity(this)
            categoryPopupActivity.start()
            categoryPopupActivity.setOnCLickedListenr(object : CategoryPopupActivity.ButtonClickLisener{
                override fun onClicked(category: String) {
                    var temp = Category(category)
                    categoryDB.categoryDao().insert(temp)
                    val tempList = categoryDB.categoryDao().getAll()
                    categoryList.clear()
                    categoryList.addAll(tempList)
                    Log.d("find","insert성공")
                    Log.d("find", tempList.size.toString())
                    Log.d("find", categoryList.size.toString())
                }
            })
        }
    }

    fun initBackBtn(){
        addBackBtn.setOnClickListener {
            val finishIntent = Intent(this, MainActivity::class.java)
            finishIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK)
            finishIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
            startActivity(finishIntent)
            Log.d("find","back성공")
        }
    }
}
