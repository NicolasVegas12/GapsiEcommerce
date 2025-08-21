package com.nvegas.presentation.ui.pages.splash

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.nvegas.presentation.navigation.components.Navigator
import com.nvegas.presentation.navigation.destinations.RootDestination
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class SplashViewModel @Inject constructor(
    private val navigator: Navigator,
) : ViewModel() {

    init {
        viewModelScope.launch {
            navigateToMain()
        }
    }

    private suspend fun navigateToMain() {
        delay(3000)
        navigator.navigateAndDeletePrevious(RootDestination.MainGraph)
    }


}