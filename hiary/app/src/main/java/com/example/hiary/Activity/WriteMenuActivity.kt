package com.example.hiary.Activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.hiary.Adapter.WriteMenuAdapter
import com.example.hiary.Data.MainContents
import com.example.hiary.Data.SubContents
import com.example.hiary.R
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_write_menu.*

class WriteMenuActivity : AppCompatActivity() {
    var subContentArray: ArrayList<SubContents> = ArrayList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_write_menu)
//
        writeMenuRecyclerView.layoutManager = LinearLayoutManager(this).also { it.orientation = LinearLayoutManager.HORIZONTAL }
        writeMenuRecyclerView.adapter = WriteMenuAdapter(subContentArray,this)


        finishBtn.setOnClickListener {
            val finishIntent = Intent(this, MainActivity::class.java)
            finishIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK)
            finishIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
            startActivity(finishIntent)
        }
    }
}