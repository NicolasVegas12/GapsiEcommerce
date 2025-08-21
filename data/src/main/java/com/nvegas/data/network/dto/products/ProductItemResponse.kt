package com.nvegas.data.network.dto.products

import kotlinx.serialization.Serializable

@Serializable
data class ProductItemResponse(
    val name:String,
    val price:Int,
    val image:String,
)
