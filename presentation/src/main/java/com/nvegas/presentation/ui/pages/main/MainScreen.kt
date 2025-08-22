package com.nvegas.presentation.ui.pages.main

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.SearchBar
import androidx.compose.material3.adaptive.currentWindowAdaptiveInfo
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.paging.LoadState
import androidx.paging.compose.LazyPagingItems
import com.nvegas.core.ui.text.TextComponent
import com.nvegas.domain.models.ProductItemModel
import com.nvegas.presentation.ui.components.config.DeviceConfiguration
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
        TextComponent("Busqueda de productos", style =MaterialTheme.typography.titleMedium)
        Spacer(modifier = Modifier.height(16.dp))
        SearchBar(
            query = searchQuery,
            onQueryChange = setSeachQuery,
            onSearch = {query->
                setSeachQuery(query)
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
                    TextComponent(it, modifier = Modifier.clickable {
                        setSeachQuery(it)
                        search()
                        isSearchActive = false
                    })
                }
            }
        }

        val windowSizeClass = currentWindowAdaptiveInfo().windowSizeClass
        val deviceConfiguration = DeviceConfiguration.fromWindowSizeClass(windowSizeClass)


        when(deviceConfiguration){
            DeviceConfiguration.MOBILE_PORTRAIT, DeviceConfiguration.TABLET_PORTRAIT-> {

                LazyColumn(
                    verticalArrangement = Arrangement.spacedBy(16.dp),
                    modifier = Modifier.padding(16.dp).fillMaxWidth(),
                    horizontalAlignment = Alignment.CenterHorizontally,

                    )
                {
                    products?.let {
                        when (val state = products.loadState.refresh) {
                            is LoadState.Loading -> {
                                // Loading inicial (cuando das buscar y demora)
                                item {
                                    LoadingItem(80.dp, 80.dp)
                                }
                            }
                            is LoadState.Error -> {
                                item {
                                    TextComponent("Error: ${state.error.message}")
                                }
                            }
                            else -> {
                                items(products.itemCount) { index ->
                                    products[index]?.let {
                                        ProductsItemsComponent(it)
                                    }
                                }
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

            else->{
                LazyVerticalGrid(
                    columns = androidx.compose.foundation.lazy.grid.GridCells.Fixed(3),
                    verticalArrangement = Arrangement.spacedBy(16.dp),
                    horizontalArrangement = Arrangement.spacedBy(16.dp),
                ) {
                    products?.let {
                        when (val state = products.loadState.refresh) {
                            is LoadState.Loading -> {
                                // Loading inicial (cuando das buscar y demora)
                                item {
                                    LoadingItem(80.dp, 80.dp)
                                }
                            }
                            is LoadState.Error -> {
                                item {
                                    TextComponent("Error: ${state.error.message}")
                                }
                            }
                            else -> {
                                items(products.itemCount) { index ->
                                    products[index]?.let {
                                        ProductsItemsComponent(it)
                                    }
                                }
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



    }
}

