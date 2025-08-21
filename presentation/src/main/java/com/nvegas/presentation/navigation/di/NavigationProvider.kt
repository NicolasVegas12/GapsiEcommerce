package com.nvegas.presentation.navigation.di

import com.nvegas.presentation.navigation.components.Navigator
import com.nvegas.presentation.navigation.components.NavigatorImpl
import com.nvegas.presentation.navigation.destinations.RootDestination
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NavigationProvider {
    @Provides
    @Singleton
    fun navigatorProvider(): Navigator =
        NavigatorImpl( RootDestination.SplashGraph)
}