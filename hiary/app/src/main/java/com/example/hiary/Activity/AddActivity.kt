package com.example.hiary.Activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.CursorAdapter
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

        var categorySwitch: String?

        var categoryList: ArrayList<String> = arrayListOf();
        baseData(categoryList)

        var addActivityspinnerAdapter = ArrayAdapter(
            this,
            android.R.layout.simple_expandable_list_item_1,
            categoryList
        )
        addSelectMenu.adapter = addActivityspinnerAdapter // spinner
        addSelectMenu.setSelection(0)
        //Do it => Category <T> <=> String

        addSelectMenu.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                if(categoryList.get(position).equals(1)){
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
    fun baseData(categoryList : ArrayList<String>){
        categoryList.add("선택하세요")
        categoryList.add("추가")
    }
}