package com.nvegas.data.network.dto.products

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ProductsResponse (
    @SerialName("item") val data:ProductsDataResponse= ProductsDataResponse(),

)