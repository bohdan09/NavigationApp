package com.example.navigationapp.view.navigation.graphs.profile

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigation
import com.example.navigationapp.navigation.AppNavigator
import com.example.navigationapp.navigation.NavFlow


@ExperimentalAnimationApi
fun NavGraphBuilder.profileGraph(route: NavFlow, appNavigator: AppNavigator) =
    navigation(
        route = route.flowRoute.route,
        startDestination = ProfileFlow.ProfileScreen.flowRoute.route
    ) {
        composable(
            ProfileFlow.ProfileScreen.flowRoute.route
        ) { backStackEntry ->
            Box(modifier = Modifier.fillMaxSize()) {
                Text(
                    modifier = Modifier.align(Alignment.Center), text = "PROFILE"
                )
            }
        }
    }
