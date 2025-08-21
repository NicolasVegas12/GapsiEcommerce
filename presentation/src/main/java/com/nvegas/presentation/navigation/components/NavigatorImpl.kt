package com.nvegas.presentation.navigation.components

import androidx.navigation.NavOptionsBuilder
import com.nvegas.presentation.navigation.destinations.Destination
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.receiveAsFlow

class NavigatorImpl(
    override val startDestination: Destination
) : Navigator {


    private val _navigationActions = Channel<NavigationAction>()
    override val navigationActions = _navigationActions.receiveAsFlow()


    override suspend fun navigate(
        destination: Destination,
        navOptions: NavOptionsBuilder.() -> Unit,
    ) {
        _navigationActions.send(
            NavigationAction.Navigate(
                destination = destination,
                navOptions = navOptions,
            )
        )
    }

    override suspend fun navigateAndDeletePrevious(destination: Destination) {
        _navigationActions.send(
            NavigationAction.NavigateAndDeletePrevious(
                destination = destination,
            )
        )
    }

    override suspend fun navigateUp() {
        _navigationActions.send(NavigationAction.NavigateUp)
    }


}