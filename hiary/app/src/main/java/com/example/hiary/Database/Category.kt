package com.example.hiary.Database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "category")
class Category{
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo
    var no: Long?= null
    @ColumnInfo
    var category: String = ""

    constructor(category: String){
        this.category = category
    }
}