package com.nvegas.presentation.ui.pages.splash

import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.nvegas.presentation.navigation.destinations.RootDestination
import com.nvegas.presentation.navigation.destinations.SplashDestination

fun NavGraphBuilder.splashGraph() {
    navigation<RootDestination.SplashGraph>(
        startDestination = SplashDestination.SplashScreen
    ) {
        composable<SplashDestination.SplashScreen> {
            val viewModel = hiltViewModel<SplashViewModel>()


        }

    }
}