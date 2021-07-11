package com.example.hiary.Activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.hiary.Adapter.MainAdapter
import com.example.hiary.Database.Content.Content
import com.example.hiary.R
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    var mainContentArray: MutableList<Content> = mutableListOf() //contents class RecyclerView Data Array

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

             mainPostBtn.setOnClickListener{
            val mainPostIntent = Intent(this, AddActivity::class.java)
                 mainPostIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK)
                 mainPostIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
            startActivity(mainPostIntent)
        }
    }

}