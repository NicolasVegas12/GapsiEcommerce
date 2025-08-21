package com.nvegas.domain.repositories

import kotlinx.coroutines.flow.Flow

interface ISuggestRepository {
    suspend fun insertSuggestion(text:String)
     fun getSuggestions(): Flow<List<String>>
}