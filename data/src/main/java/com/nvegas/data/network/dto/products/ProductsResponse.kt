package com.nvegas.data.network.dto.products

import kotlinx.serialization.Serializable

@Serializable
data class ProductsResponse (
    val props:ProductPropsResponse = ProductPropsResponse()
)