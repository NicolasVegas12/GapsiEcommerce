package com.nvegas.data.network.dto.products

import kotlinx.serialization.Serializable

@Serializable
data class ProductPropsResponse(
    val pageProps: ProductPagePropsResponse = ProductPagePropsResponse(),
)
