package com.nvegas.data.local.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.nvegas.data.local.database.entities.SuggestEntity


@Database(
    entities = [
        SuggestEntity::class
    ],
    version = 1
)

abstract class GapsiDatabase: RoomDatabase() {
}