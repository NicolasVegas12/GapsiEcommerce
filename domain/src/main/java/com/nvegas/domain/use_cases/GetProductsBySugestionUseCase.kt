package com.nvegas.domain.use_cases

import com.nvegas.domain.qualifiers.IoDispatcher
import com.nvegas.domain.repositories.IProductsRepository
import com.nvegas.domain.repositories.ISuggestRepository
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext
import javax.inject.Inject

class GetProductsBySugestionUseCase @Inject constructor(
    private val repository: IProductsRepository,
    private val suggestRepository: ISuggestRepository,
    @IoDispatcher private val dispatcher: CoroutineDispatcher
) {
    suspend operator fun invoke(
        suggestion: String,
        page: Int
    ) = withContext(dispatcher){
        suggestRepository.insertSuggestion(suggestion)
        repository.getProductsFromApi(suggestion, page)
    }
}