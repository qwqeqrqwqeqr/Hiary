package com.example.hiary.Activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.hiary.Adapter.AddAdapter
import com.example.hiary.Database.Category.Category
import com.example.hiary.Database.Category.CategoryDB
import com.example.hiary.Popup.CategoryPopupActivity
import com.example.hiary.R
import kotlinx.android.synthetic.main.activity_add.*
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

        val adapter = AddAdapter(categoryDB,categoryList,this){
                category->
                    val addIntent = Intent(this, StartActivity::class.java)
                    addIntent.putExtra("category", category.category.toString())
                    addIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK)
                    addIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
                    ContextCompat.startActivity(this, addIntent, null)
        }

        val layoutmanager = LinearLayoutManager(this)
        addMenuRecyclerView.adapter = adapter
        addMenuRecyclerView.layoutManager = layoutmanager
        addMenuRecyclerView.setHasFixedSize(true)
        initBackBtn()



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
        }
    }
}
