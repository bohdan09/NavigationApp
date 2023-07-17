package com.example.navigationapp.view.navigation.graphs.home

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigation
import androidx.navigation.navArgument
import com.example.navigationapp.navigation.AppNavigator
import com.example.navigationapp.navigation.NavFlow
import com.example.navigationapp.navigation.util.firstKeyValue
import com.example.navigationapp.navigation.util.routeWithKeys
import com.example.navigationapp.view.screens.home.HomeFirstScreen
import com.example.navigationapp.view.screens.home.HomeScreen

@ExperimentalAnimationApi
fun NavGraphBuilder.homeGraph(route: NavFlow, appNavigator: AppNavigator) =
    navigation(
        route = route.flowRoute.route,
        startDestination = HomeFlow.HomeScreen.flowRoute.route
    ) {
        composable(
            HomeFlow.HomeScreen.flowRoute.route
        ) {
            HomeScreen { value ->
                appNavigator.navigateToFlowWithArgs(
                    HomeFlow.HomeFirst,
                    navOptions = null,
                    HomeFlow.HomeFirst.argKey1!! to value.ifEmpty { "default" }
                )
            }
        }

        composable(
            HomeFlow.HomeFirst.routeWithKeys().route,
            arguments = listOf(
                navArgument(
                    HomeFlow.HomeFirst.argKey1 ?: ""
                ) { type = NavType.StringType }
            )
        ) { backStackEntry ->
            val receivedValue = backStackEntry.firstKeyValue(HomeFlow.HomeFirst) ?: ""
            HomeFirstScreen(receivedValue = receivedValue) {
                appNavigator.navigateUp()
            }
        }
    }
