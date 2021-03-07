package com.example.hiary.Activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.hiary.R
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_write_menu.*

class WriteMenuActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_write_menu)


        finishBtn.setOnClickListener {
            val finishIntent = Intent(this, MainActivity::class.java)
            startActivity(finishIntent)
        }
    }
}