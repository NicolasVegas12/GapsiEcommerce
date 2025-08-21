package com.nvegas.data.network.dto.products

import kotlinx.serialization.Serializable

@Serializable
data class ProductsItemsStackResponse(
    val title:String = "",
    val count:Int = 0,
    val items:List<ProductItemResponse> = emptyList()
)
