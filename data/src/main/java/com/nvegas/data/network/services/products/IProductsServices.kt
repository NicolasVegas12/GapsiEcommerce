package com.nvegas.data.network.services.products

import com.nvegas.data.network.contract.DataContract
import com.nvegas.data.network.dto.products.ProductsResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Query

interface IProductsServices {

    @GET(DataContract.GET_PRODUCTS)
    suspend fun getProducts(
        @Query("keyword") keyword: String,
        @Query("page") page: Int,
        @Query("sortBy") sortBy: String,
        @Header("x-rapidapi-key") token:String
    ): Response<ProductsResponse>
}