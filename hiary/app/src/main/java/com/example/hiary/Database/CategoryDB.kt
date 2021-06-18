package com.example.hiary.Database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

//https://raphaelh.tistory.com/41
@Database(entities = arrayOf(Category::class),version = 3,exportSchema = false)
abstract class CategoryDB:RoomDatabase(){
    abstract fun categoryDao(): CategoryDao
    companion object {
        private var instance: CategoryDB? = null

        @Synchronized
        fun getInstance(context: Context): CategoryDB? {
            if (instance == null) {
                instance = Room.databaseBuilder(
                    context.applicationContext,
                    CategoryDB::class.java,
                    "category-contacts"
                )
                    .allowMainThreadQueries()
                    .build()
            }
            return instance
        }
    }
}