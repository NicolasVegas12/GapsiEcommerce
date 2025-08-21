package com.nvegas.presentation.ui.pages.root

import androidx.lifecycle.ViewModel
import com.nvegas.presentation.navigation.components.NavigationAction
import com.nvegas.presentation.navigation.components.Navigator
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

@HiltViewModel
class RootViewModel @Inject constructor(
    private val navigator: Navigator
) : ViewModel() {
    val navigationActions: Flow<NavigationAction> = navigator.navigationActions
    val startDestination = navigator.startDestination
}