package com.nvegas.data.repositories

import com.nvegas.data.local.database.dao.SuggestionsDao
import com.nvegas.data.local.database.entities.SuggestEntity
import com.nvegas.domain.repositories.ISuggestRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import java.time.LocalDateTime
import java.time.ZoneOffset
import java.util.UUID
import javax.inject.Inject

class SuggestionsRepository @Inject constructor(
    private val dao: SuggestionsDao
) : ISuggestRepository {

    override suspend fun insertSuggestion(text: String) {

        val suggest = dao.getByText(text) ?: SuggestEntity(
            id = UUID.randomUUID().toString(),
            value = text,
            0
        )
        dao.insert(suggest.copy(timestamp = LocalDateTime.now().toEpochSecond(ZoneOffset.UTC)))
    }

    override  fun getSuggestions(): Flow<List<String>> {
        return dao.getSuggestions()
            .map {
                it.map { it.value }
            }

    }
}