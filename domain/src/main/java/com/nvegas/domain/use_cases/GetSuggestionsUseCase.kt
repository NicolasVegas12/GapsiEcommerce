package com.nvegas.domain.use_cases

import com.nvegas.domain.qualifiers.IoDispatcher
import com.nvegas.domain.repositories.ISuggestRepository
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class GetSuggestionsUseCase @Inject constructor(
    private val suggestionsRepository: ISuggestRepository,
    @IoDispatcher private val dispatcher: CoroutineDispatcher
) {

    operator fun invoke(): Flow<List<String>> {
        return suggestionsRepository.getSuggestions().flowOn(dispatcher)
    }
}