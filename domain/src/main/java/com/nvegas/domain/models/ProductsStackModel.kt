package com.nvegas.domain.models

data class ProductsStackModel (
    val title:String = "",
    val count:Int = 0,
    val items:List<ProductItemModel> = emptyList()

)