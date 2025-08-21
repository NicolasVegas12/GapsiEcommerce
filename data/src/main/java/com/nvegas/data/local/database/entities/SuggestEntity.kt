package com.nvegas.data.local.database.entities

import androidx.room.Entity

@Entity
data class SuggestEntity(
    val id:String,
    val value:String,
    val timestamp:Long
)
