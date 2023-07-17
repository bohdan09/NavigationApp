package com.example.navigationapp.navigation.handleNavigation

import android.util.Log
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.navigation.NavController
import androidx.navigation.NavOptions
import com.example.navigationapp.navigation.AppNavigator
import com.example.navigationapp.navigation.command.NavigationCommand
import com.example.navigationapp.navigation.util.NavigateBack
import com.example.navigationapp.navigation.util.NavigateToFlow
import kotlinx.coroutines.flow.SharedFlow

@Composable
fun HandleNavigation(
    appNavigator: AppNavigator,
    navigationCommand: SharedFlow<NavigationCommand?>,
    back: @Composable (NavController) -> Unit = {
        NavigateBack(it)
    },
    navToOptions: NavOptions? = null
) = HandleNavigation(
    navController = appNavigator.navController,
    navigationCommand = navigationCommand,
    back,
    navToOptions
)

@Composable
fun HandleNavigation(
    navController: NavController,
    navigationCommand: SharedFlow<NavigationCommand?>,
    back: @Composable (NavController) -> Unit = { NavigateBack(it) },
    navToOptions: NavOptions? = null
) {
    val navigation by navigationCommand.collectAsState(initial = null)
    when (val result = navigation) {
        is NavigationCommand.To -> {
            NavigateToFlow(navController, result.direction.flowRoute.route, navToOptions)
        }

        NavigationCommand.Back -> {
            back(navController)
        }

        null -> {
        }
    }
}

@Composable
fun HandleNavigation(
    navController: NavController,
    navigation: NavigationCommand?,
    back: @Composable (NavController) -> Unit = { NavigateBack(it) },
    navToOptions: NavOptions? = null
) {
    when (navigation) {
        is NavigationCommand.To -> {
            NavigateToFlow(navController, navigation.direction.flowRoute.route, navToOptions)
        }

        NavigationCommand.Back -> {
            back(navController)
        }

        null -> {
            Log.d("HandleNavigation", "navigation command is null")
        }
    }
}