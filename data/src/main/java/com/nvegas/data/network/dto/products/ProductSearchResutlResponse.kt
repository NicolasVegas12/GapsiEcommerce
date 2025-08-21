package com.nvegas.data.network.dto.products

import kotlinx.serialization.Serializable

@Serializable
data class ProductSearchResutlResponse(
    val itemStacks:List<ProductsItemsStackResponse> = emptyList()
)