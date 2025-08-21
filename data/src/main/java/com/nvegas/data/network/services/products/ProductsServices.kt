package com.nvegas.data.network.services.products

import com.nvegas.data.network.dto.products.ProductsItemsStackResponse
import javax.inject.Inject

class ProductsServices @Inject constructor(
    private val api:IProductsServices
) {

    suspend fun getProductsBySuggestion(
        keyword: String,
        page: Int,
    ): List<ProductsItemsStackResponse> {

        val response = api.getProducts(keyword,page,"best_match")

        return if(response.isSuccessful){
            response.body()?.props?.pageProps?.initialData?.searchResult?.itemStacks ?: emptyList()
        }else{
            emptyList()
        }

    }
}