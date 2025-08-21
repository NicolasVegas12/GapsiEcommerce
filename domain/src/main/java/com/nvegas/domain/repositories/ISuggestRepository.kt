package com.nvegas.domain.repositories

interface ISuggestRepository {
    suspend fun insertSuggestion(text:String)
    suspend fun getSuggestions():List<String>
}