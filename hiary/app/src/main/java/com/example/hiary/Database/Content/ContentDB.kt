package com.example.hiary.Database.Content

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase


@Database(entities = arrayOf(Content::class),version = 3,exportSchema = false)
abstract class ContentDB:RoomDatabase() {
    abstract fun contentDao(): ContentDao
    companion object{
        private  var instance: ContentDB?= null

        @Synchronized
        fun getInstance(context: Context): ContentDB?{
            if(instance ==null){
                instance = Room.databaseBuilder(
                    context.applicationContext,
                    ContentDB::class.java,
                    "content-contacts"
                ).allowMainThreadQueries().build()
            }

            return instance
        }
    }
}