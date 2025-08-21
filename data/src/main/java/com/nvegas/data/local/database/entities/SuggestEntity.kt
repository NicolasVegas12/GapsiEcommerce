package com.nvegas.data.local.database.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class SuggestEntity(
    @PrimaryKey
    val id:String,
    val value:String,
    val timestamp:Long
)
