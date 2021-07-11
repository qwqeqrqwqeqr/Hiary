package com.example.hiary.Database.Content

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy.REPLACE
import androidx.room.Query

@Dao
interface ContentDao {
    @Query("SELECT * FROM Content" )
    fun getAll(): List<Content>

    @Insert(onConflict = REPLACE)
    fun insert(content: Content)

    @Delete
    fun delete(content: Content)
}