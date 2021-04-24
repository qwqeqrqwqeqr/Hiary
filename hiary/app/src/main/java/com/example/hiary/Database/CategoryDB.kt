package com.example.hiary.Database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

//data class Category (var category : String){
//
//}
@Database(entities = arrayOf(Category::class),version = 1,exportSchema = false)
abstract class CategoryDB:RoomDatabase(), MutableList<Category> {
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