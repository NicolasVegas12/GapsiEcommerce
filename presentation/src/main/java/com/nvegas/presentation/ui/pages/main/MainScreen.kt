package com.nvegas.presentation.ui.pages.main

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.SearchBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.paging.LoadState
import androidx.paging.compose.LazyPagingItems
import com.nvegas.core.ui.text.TextComponent
import com.nvegas.domain.models.ProductItemModel
import com.nvegas.presentation.ui.pages.main.components.items.LoadingItem
import com.nvegas.presentation.ui.pages.main.components.items.ProductsItemsComponent

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainScreen(
    products: LazyPagingItems<ProductItemModel>?,
    suggestions: List<String> = emptyList(),
    searchQuery: String,
    setSeachQuery: (String) -> Unit,
    search: () -> Unit,
) {
    var isSearchActive by remember { mutableStateOf(false) }
    Column {
        SearchBar(
            query = searchQuery,
            onQueryChange = setSeachQuery,
            onSearch = {
                search()
                isSearchActive = false
            },
            active = isSearchActive,
            onActiveChange = { isSearchActive = it },
            placeholder = { TextComponent("Buscar Producto...") },
            modifier = Modifier.fillMaxWidth(),
            windowInsets = WindowInsets(0.dp, 0.dp, 0.dp, 0.dp)
        ) {
            Column(verticalArrangement = Arrangement.spacedBy(8.dp),
                modifier = Modifier.padding(horizontal = 16.dp)) {
                suggestions.map{
                    TextComponent(it)
                }
            }
        }
        LazyColumn(
            verticalArrangement = Arrangement.spacedBy(16.dp),
            modifier = Modifier.padding(16.dp)
        ) {



            products?.let {

                items(products.itemCount) { index ->
                    products[index]?.let {
                        ProductsItemsComponent(it)
                    }

                }
                if (products.loadState.append is LoadState.Loading) {
                    item { LoadingItem(80.dp, 80.dp) }
                }
            } ?: item {
                TextComponent("Realizar una busqueda para poder visibilizar los productos ")
            }


        }
    }
}

