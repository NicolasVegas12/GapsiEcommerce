package com.nvegas.data.network.dto.products

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ProductItemResponse(
    @SerialName("__typename") val type:String = "",
    val name:String = "",
    val price:Int = 0,
    val image:String= "",
)
