package com.nvegas.presentation.ui.pages.root

import androidx.compose.runtime.Composable
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import com.nvegas.presentation.navigation.components.NavigationAction
import com.nvegas.presentation.navigation.components.ObserveAsEvents
import com.nvegas.presentation.navigation.destinations.Destination
import com.nvegas.presentation.ui.pages.splash.splashGraph
import kotlinx.coroutines.flow.Flow

@Composable
fun RootNavGraph(
    navController: NavHostController,
    startDestination: Destination,
    flow: Flow<NavigationAction>
) {

    ObserveAsEvents(flow = flow) { action ->
        when (action) {
            is NavigationAction.Navigate -> navController.navigate(
                action.destination
            ) {
                action.navOptions(this)
            }

            NavigationAction.NavigateUp -> navController.navigateUp()
            is NavigationAction.NavigateAndDeletePrevious -> navController.navigate(
                action.destination
            ) {
                popUpTo(navController.graph.findStartDestination().id) {
                    inclusive = true
                }
                navController.graph.setStartDestination(action.destination)
            }
        }
    }
    NavHost(
        navController = navController,
        startDestination = startDestination,
    ) {
        splashGraph()
    }
}