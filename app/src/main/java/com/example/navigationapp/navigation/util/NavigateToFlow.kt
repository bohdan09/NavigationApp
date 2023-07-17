package com.example.navigationapp.navigation.util

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.navigation.NavController
import androidx.navigation.NavOptions
import androidx.navigation.Navigator

@Composable
fun NavigateToFlow(
    navController: NavController,
    route: String,
    navOptions: NavOptions? = null,
    navigatorExtras: Navigator.Extras? = null
) = LaunchedEffect(
    key1 = Unit,
    block = {
        navController.navigate(route, navOptions, navigatorExtras)
    }
)

@Composable
fun NavigateBack(
    navController: NavController,
) = LaunchedEffect(
    key1 = Unit,
    block = {
        navController.navigateUp()
    }
)