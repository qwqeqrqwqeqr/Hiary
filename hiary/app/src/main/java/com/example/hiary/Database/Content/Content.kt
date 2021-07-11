package com.example.hiary.Database.Content

import android.media.Image
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.sql.Time
import java.util.*


@Entity(tableName = "Content")
class Content {
    @PrimaryKey(autoGenerate = true) var no: Long?= null
    @ColumnInfo
    var title: String?= null //제목
    var contents: String?= null //내용
    var date: String ?= null //now
    var time: String ?= null //실행시간
    var type: Int = 0
    var image: Int = 0

    companion object{
        const val  TEXT_TYPE =0
        const val  IMAGE_TYPE =1
    }
}