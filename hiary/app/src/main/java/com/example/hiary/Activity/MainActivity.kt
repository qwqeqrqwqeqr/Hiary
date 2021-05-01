package com.example.hiary.Activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.hiary.Adapter.MainAdapter
import com.example.hiary.DataClass.MainContents
import com.example.hiary.R
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    var mainContentArray: MutableList<MainContents> = mutableListOf() //contents class RecyclerView Data Array

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mainRecyclerView.layoutManager = LinearLayoutManager(this)
        mainRecyclerView.adapter = MainAdapter(mainContentArray,this)

             mainPostBtn.setOnClickListener{
            val mainPostIntent = Intent(this, AddActivity::class.java)
                 mainPostIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK)
                 mainPostIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
            startActivity(mainPostIntent)
        }
    }

}