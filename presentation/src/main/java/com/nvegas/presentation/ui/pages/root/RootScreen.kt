package com.nvegas.presentation.ui.pages.root

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController

@Composable
fun RootScreen(navController: NavHostController, modifier: Modifier = Modifier) {
    val viewModel = hiltViewModel<RootViewModel>()
    Scaffold(
        modifier = modifier.fillMaxSize(),

    ) { paddingValue ->

        Box(
            modifier = Modifier
                .padding(paddingValue)
        ) {
            RootNavGraph(
                navController = navController,
                startDestination = viewModel.startDestination,
                flow = viewModel.navigationActions,
            )
        }
    }


}
