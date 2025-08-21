package com.nvegas.presentation.navigation.destinations

import kotlinx.serialization.Serializable

sealed class SplashDestination : Destination {
    @Serializable
    data object SplashScreen : SplashDestination()

}