package com.example.hiary.Database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.*

@Entity(tableName = "Category")
class Category{
    @PrimaryKey(autoGenerate = true) var no: Long?= null
    @ColumnInfo
    var category: String? = null

    constructor(category: String){
        this.category = category
    }
}