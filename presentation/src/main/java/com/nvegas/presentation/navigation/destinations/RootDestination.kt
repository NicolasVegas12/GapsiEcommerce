package com.nvegas.presentation.navigation.destinations

import kotlinx.serialization.Serializable


sealed class RootDestination : Destination {


    @Serializable
    data object SplashGraph : RootDestination()

    @Serializable
    data object MainGraph : RootDestination()
}