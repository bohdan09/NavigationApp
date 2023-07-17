package com.example.navigationapp.view.screens.splash

import com.example.navigationapp.navigation.command.NavigationCommand
import com.example.navigationapp.view.navigation.graphs.home.HomeFlow
import com.example.navigationapp.viewmodel.BaseViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class SplashScreenViewModel : BaseViewModel() {

    private val _nextScreen: MutableStateFlow<NavigationCommand?> = MutableStateFlow(null)
    var nextScreen: StateFlow<NavigationCommand?> = _nextScreen.asStateFlow()

    init {
        navigateToHomeFlow()
    }

    private fun navigateToHomeFlow() {
        launch(ioContext) {
            _nextScreen.emit(NavigationCommand.To(HomeFlow.HomeScreen))
        }
    }
}