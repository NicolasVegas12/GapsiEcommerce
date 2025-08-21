package com.nvegas.domain.repositories

import com.nvegas.domain.models.ProductsStackModel

interface IProductsRepository {
    suspend fun getProductsFromApi(
        suggestion:String,
        page:Int
    ): List<ProductsStackModel>
}