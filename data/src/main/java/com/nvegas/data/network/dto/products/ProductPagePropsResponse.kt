package com.nvegas.data.network.dto.products

import kotlinx.serialization.Serializable

@Serializable
data class ProductPagePropsResponse(
    val initialData:ProductInitialDataResponse = ProductInitialDataResponse(),
)
