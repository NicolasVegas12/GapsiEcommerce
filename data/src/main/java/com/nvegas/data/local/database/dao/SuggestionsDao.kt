package com.nvegas.data.local.database.dao

import androidx.room.Dao
import androidx.room.Query
import com.nvegas.data.local.database.entities.SuggestEntity

@Dao
interface SuggestionsDao:BaseDao<SuggestEntity> {

    @Query("SELECT * FROM SuggestEntity ORDER BY timestamp DESC LIMIT 5")
    suspend fun getSuggestions():List<SuggestEntity>

    @Query("SELECT * FROM SuggestEntity WHERE value = :value")
    suspend fun getByText(value:String):SuggestEntity?

}