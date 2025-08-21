package com.nvegas.data.network.dto.products

import kotlinx.serialization.Serializable

@Serializable
data class ProductInitialDataResponse(
    val searchResult:ProductSearchResutlResponse = ProductSearchResutlResponse(),
)
