package com.nvegas.data.repositories

import com.nvegas.data.mappers.ProductsMapper.toDomain
import com.nvegas.data.network.services.products.ProductsServices
import com.nvegas.domain.models.ProductsStackModel
import com.nvegas.domain.repositories.IProductsRepository
import javax.inject.Inject

class ProductsRepository @Inject constructor(
    private val api: ProductsServices
) : IProductsRepository {

    override suspend fun getProductsFromApi(
        suggestion: String,
        page: Int
    ): List<ProductsStackModel> {
        val response = api.getProductsBySuggestion(suggestion, page)

        return response.map { it.toDomain() }
    }
}