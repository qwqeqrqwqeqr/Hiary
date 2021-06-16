package com.example.hiary.Database

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy.REPLACE
import androidx.room.Query

@Dao
interface CategoryDao {
    @Query("SELECT * FROM category")
    fun getAll(): List<Category>

    @Insert(onConflict = REPLACE)
    fun insert(category: String)

    @Delete
    fun delete(category: Category)

}