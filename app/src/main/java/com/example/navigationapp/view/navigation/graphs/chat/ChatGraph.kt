package com.example.navigationapp.view.navigation.graphs.chat

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigation
import com.example.navigationapp.navigation.AppNavigator
import com.example.navigationapp.navigation.NavFlow
import com.example.navigationapp.view.screens.chats.ChatFirstScreen
import com.example.navigationapp.view.screens.chats.ChatScreen


@ExperimentalAnimationApi
fun NavGraphBuilder.chatGraph(route: NavFlow, appNavigator: AppNavigator) =
    navigation(
        route = route.flowRoute.route,
        startDestination = ChatFlow.ChatScreen.flowRoute.route
    ) {
        composable(
            ChatFlow.ChatScreen.flowRoute.route
        ) {
            ChatScreen(appNavigator)
        }

        composable(
            ChatFlow.ChatFirstScreen.flowRoute.route
        ) {
            ChatFirstScreen(appNavigator)
        }
    }
