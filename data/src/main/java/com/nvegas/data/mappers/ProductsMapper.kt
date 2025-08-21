package com.nvegas.data.mappers

import com.nvegas.data.network.dto.products.ProductItemResponse
import com.nvegas.data.network.dto.products.ProductsItemsStackResponse
import com.nvegas.domain.models.ProductItemModel
import com.nvegas.domain.models.ProductsStackModel

object ProductsMapper {
    fun ProductsItemsStackResponse.toDomain() =ProductsStackModel(
        title = title,
        count = count,
        items = items.map { it.toDomain() }

    )
    private fun ProductItemResponse.toDomain() = ProductItemModel(
        name = name,
        price = price,
        image = image
    )
}