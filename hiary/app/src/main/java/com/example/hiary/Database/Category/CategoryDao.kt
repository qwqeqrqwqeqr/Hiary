package com.example.hiary.Database.Category

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy.REPLACE
import androidx.room.Query

@Dao
interface CategoryDao {
    @Query("SELECT * FROM Category")
    fun getAll(): List<Category>

    @Insert(onConflict = REPLACE)
    fun insert(category: Category)

    @Delete
    fun delete(category: Category)

}