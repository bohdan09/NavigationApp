package com.example.navigationapp

import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.animation.animateContentSize
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.slideOutVertically
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.SideEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import com.example.navigationapp.navigation.AppNavigator
import com.example.navigationapp.navigation.util.routeWithKeys
import com.example.navigationapp.ui.theme.NavigationAppTheme
import com.example.navigationapp.view.bottomNavigation.BottomNavFlowItem
import com.example.navigationapp.view.bottomNavigation.BottomNavItemsFlow
import com.example.navigationapp.view.bottomNavigation.BottomNavigationBar
import com.example.navigationapp.view.bottomNavigation.BottomNavigationTabViewModel
import com.example.navigationapp.view.navigation.graphs.chat.chatGraph
import com.example.navigationapp.view.navigation.graphs.home.HomeFlow
import com.example.navigationapp.view.navigation.graphs.home.homeGraph
import com.example.navigationapp.view.navigation.graphs.profile.profileGraph
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import kotlinx.coroutines.flow.collectLatest

@ExperimentalAnimationApi
fun ComponentActivity.navigationApp() = setContent {
    NavigationAppTheme {
        val systemUiController = rememberSystemUiController()
        SideEffect {
            systemUiController.setSystemBarsColor(
                Color.Transparent,
            )
        }
        NavigationAppNavigation()
    }
}

@ExperimentalAnimationApi
@Composable
fun NavigationAppNavigation() {
    val navController = rememberNavController()
    val appNavigator: AppNavigator = remember(navController) {
        AppNavigator(navController)
    }

    val viewModel: BottomNavigationTabViewModel = viewModel()
    val bottomBarItems = viewModel.menuItems

    var visibleMenu by remember {
        mutableStateOf(true)
    }
    LaunchedEffect(key1 = navController.currentBackStackEntryFlow) {
        navController.currentBackStackEntryFlow.collectLatest {
            visibleMenu = it.destination.route != HomeFlow.HomeFirst.routeWithKeys().route
        }
    }
    Scaffold(
        modifier = Modifier
            .navigationBarsPadding()
            .animateContentSize(),
        bottomBar = {
            HideableBottomNavigationBar(
                visibleMenu,
                bottomBarItems,
                appNavigator
            )
        },
    ) { paddingValues ->

        NavHost(
            modifier = Modifier.padding(paddingValues),
            navController = navController,
            startDestination = BottomNavItemsFlow.Home.flowRoute.route
        ) {
            homeGraph(BottomNavItemsFlow.Home, appNavigator)
            chatGraph(BottomNavItemsFlow.Chats, appNavigator)
            profileGraph(BottomNavItemsFlow.Profile, appNavigator)
        }
    }
}

@Composable
private fun HideableBottomNavigationBar(
    showBottomBar: Boolean,
    bottomBarItems: List<BottomNavFlowItem>,
    appNavigator: AppNavigator,
) {
    // here we can add some animation
    AnimatedVisibility(
        visible = showBottomBar,
        enter = slideInVertically(initialOffsetY = { it }),
        exit = slideOutVertically(targetOffsetY = { it }),
        content = {
            BottomNavigationBar(
                appNavigator = appNavigator,
                items = bottomBarItems
            )
        }
    )
}