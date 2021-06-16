package com.example.hiary.Activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
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
import kotlin.collections.MutableList as MutableList

class AddActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add)
        var categoryList : MutableList<Category>? = null
        var categoryDB = CategoryDB.getInstance(this)!!
        if (categoryList != null) {
            updateCategoryList(categoryList,categoryDB)
        }
        val adapter = AddAdapter(categoryDB,categoryList,this)
        addMenuRecyclerView.layoutManager = LinearLayoutManager(this)
        addMenuRecyclerView.adapter = adapter
        initClickBtn()

        addCategoryBtn.setOnClickListener {
            val categoryPopupActivity = CategoryPopupActivity(this)
            categoryPopupActivity.start()
            categoryPopupActivity.setOnCLickedListenr(object : CategoryPopupActivity.ButtonClickLisener{
                override fun onClicked(category: String) {
                    categoryDB.categoryDao().insert(category)
                    if (categoryList != null) {
                        updateCategoryList(categoryList,categoryDB)
                    }
                }
            })
        }



    }
    fun updateCategoryList(categoryList: MutableList<Category> ,categoryDB: CategoryDB ){
        categoryList.isEmpty()
        val savedcategoryList = categoryDB.categoryDao().getAll()
        if(savedcategoryList.isNotEmpty()){
            categoryList?.addAll(savedcategoryList)
        }
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
