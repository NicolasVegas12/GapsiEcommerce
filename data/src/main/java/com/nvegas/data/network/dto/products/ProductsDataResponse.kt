package com.nvegas.data.network.dto.products

import kotlinx.serialization.Serializable

@Serializable
data class ProductsDataResponse(
    val props:ProductPropsResponse = ProductPropsResponse()
)
