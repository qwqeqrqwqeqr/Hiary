package com.example.hiary.Data

import android.widget.ImageView
import java.sql.Time
import java.util.*

data class MainContents (val type : Int, var title: String, var contents: String, var date: String, var time: String){
    var image: ImageView? = null
}

//Calender 클래스 사용