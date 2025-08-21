package com.nvegas.presentation.navigation.components

import androidx.navigation.NavOptionsBuilder
import com.nvegas.presentation.navigation.destinations.Destination

sealed interface NavigationAction {

    data class Navigate(
        val destination: Destination,
        val navOptions: NavOptionsBuilder.() -> Unit = {}
    ) : NavigationAction

    data class NavigateAndDeletePrevious(val destination: Destination) : NavigationAction

    data object NavigateUp : NavigationAction

}