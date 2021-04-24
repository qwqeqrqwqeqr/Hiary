package com.example.hiary.DataClass

data class MainContents (val type : Int, var imageData : Int, var title: String, var contents: String, var date: String, var time: String){

    companion object{
        const val TEXT_TYPE = 0
        const val IMAIGE_TYPE = 1
    }
}

//Calender 클래스 사용