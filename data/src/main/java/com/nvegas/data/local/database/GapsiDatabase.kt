package com.nvegas.data.local.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.nvegas.data.local.database.dao.SuggestionsDao
import com.nvegas.data.local.database.entities.SuggestEntity


@Database(
    entities = [
        SuggestEntity::class
    ],
    version = 1
)

abstract class GapsiDatabase: RoomDatabase() {

    abstract fun getSuggestionsDao(): SuggestionsDao

    companion object {
        const val DATABASE_NAME = "smartberry-db"
        fun create(context: Context): GapsiDatabase {
            return Room.databaseBuilder(
                context,
                GapsiDatabase::class.java,
                DATABASE_NAME
            )
                .allowMainThreadQueries()
                .build()
        }
    }
}