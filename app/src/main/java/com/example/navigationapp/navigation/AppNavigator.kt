package com.example.navigationapp.navigation

import androidx.annotation.MainThread
import androidx.navigation.NavController
import androidx.navigation.NavOptions
import com.example.navigationapp.navigation.util.routeWithParamsAndValues

class AppNavigator(val navController: NavController) {

    @MainThread
    fun navigateToFlow(
        navigationFlow: NavFlow,
        navOptions: NavOptions? = null
    ) = with(navController) {
        val route = navigationFlow.flowRoute
        navigate(route.route, navOptions)
    }

    @MainThread
    fun navigateToFlowWithArgs(
        navigationFlow: NavFlow,
        navOptions: NavOptions? = null,
        vararg arg: Pair<String, Any>?
    ) = with(navController) {
        navigate(navigationFlow.routeWithParamsAndValues(*arg), navOptions)
    }

    fun navigateUp() {
        navController.navigateUp()
    }
}