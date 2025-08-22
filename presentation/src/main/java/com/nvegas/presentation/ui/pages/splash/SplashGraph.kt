package com.nvegas.presentation.ui.pages.splash

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.nvegas.core.ui.text.TextComponent
import com.nvegas.presentation.navigation.destinations.RootDestination
import com.nvegas.presentation.navigation.destinations.SplashDestination

fun NavGraphBuilder.splashGraph() {
    navigation<RootDestination.SplashGraph>(
        startDestination = SplashDestination.SplashScreen
    ) {
        composable<SplashDestination.SplashScreen> {
            val viewModel = hiltViewModel<SplashViewModel>()

            Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                TextComponent("GapsiEcommerce", style = MaterialTheme.typography.titleLarge)
            }
        }

    }
}