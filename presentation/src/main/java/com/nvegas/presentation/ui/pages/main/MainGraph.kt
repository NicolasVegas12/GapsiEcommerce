package com.nvegas.presentation.ui.pages.main

import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import androidx.paging.compose.collectAsLazyPagingItems
import com.nvegas.presentation.navigation.destinations.MainDestination
import com.nvegas.presentation.navigation.destinations.RootDestination

fun NavGraphBuilder.mainGraph() {
    navigation<RootDestination.MainGraph>(
        startDestination = MainDestination.MainScreenRoute
    ) {
        composable<MainDestination.MainScreenRoute> {
            val viewModel = hiltViewModel<MainScreenViewModel>()

            val pagerFlow = viewModel.pager.collectAsState().value
            val suggestions by viewModel.suggestions.collectAsState()
            val query by viewModel.suggestionText

            MainScreen(
                products = pagerFlow?.collectAsLazyPagingItems(),
                suggestions = suggestions,
                searchQuery = query,
                setSeachQuery = viewModel::updateSuggestion,
                search = viewModel::getProducts,
            )


        }

    }
}