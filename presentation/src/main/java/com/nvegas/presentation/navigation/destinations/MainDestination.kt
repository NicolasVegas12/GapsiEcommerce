package com.nvegas.presentation.navigation.destinations

import kotlinx.serialization.Serializable

sealed class MainDestination:Destination {
    @Serializable
    data object MainScreenRoute : SplashDestination()

}