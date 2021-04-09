package com.example.hiary.Activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import com.example.hiary.Data.Category
import com.example.hiary.R
import kotlinx.android.synthetic.main.activity_add.*
import java.lang.reflect.Type
import java.util.*
import kotlin.collections.ArrayList

class AddActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add)

        var categorySwitch: Category?

        var categoryList: ArrayList<Category> = arrayListOf();
        baseData(categoryList)

        var addActivityspinnerAdapter = ArrayAdapter<Category>(
            this,
            android.R.layout.simple_expandable_list_item_1,
            categoryList
        )
        addSelectMenu.adapter = addActivityspinnerAdapter // spinner

        //Do it => Category <T> <=> String

        addSelectMenu.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                if(categoryList.get(position).equals(0)){
                    val categoryDlg = CategoryPopupActivity(this@AddActivity)
                    categoryDlg.start()
                }
                categorySwitch = categoryList.get(position)
            }
            override fun onNothingSelected(parent: AdapterView<*>?) {
                categorySwitch = null
            }
        }
    }
    fun baseData(categoryList : ArrayList<Category>){
        var baseCategory = Category("선택하세요")
        var baseCategory2 = Category("추가")
        categoryList.add(baseCategory)
        categoryList.add(baseCategory2)
    }
}