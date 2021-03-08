package com.example.hiary.Activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.hiary.Data.MainContents
import com.example.hiary.R
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    var mainContentArray: ArrayList<MainContents> = ArrayList() //contents class RecyclerView Data Array

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

//        writeMenuRecyclerView.layoutManager = LinearLayoutManager(this)
//        writeMenuRecyclerView.adapter = MainAdapter(mainContentArray,this)

             mainPostBtn.setOnClickListener{
            val mainPostIntent = Intent(this, WriteMenuActivity::class.java)
                 mainPostIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK)
                 mainPostIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
            startActivity(mainPostIntent)
        }
    }

}