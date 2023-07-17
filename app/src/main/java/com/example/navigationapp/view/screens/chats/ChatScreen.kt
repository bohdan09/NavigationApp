package com.example.navigationapp.view.screens.chats

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.navigationapp.navigation.AppNavigator
import com.example.navigationapp.navigation.handleNavigation.HandleNavigation
import com.example.navigationapp.view.screens.chats.viewmodel.ChatScreenViewModel
import com.example.navigationapp.view.theme.spacing

@Composable
fun ChatScreen(appNavigator: AppNavigator) = Scaffold(Modifier.fillMaxSize()) {
    val viewModel: ChatScreenViewModel = viewModel()
    HandleNavigation(
        appNavigator = appNavigator,
        navigationCommand = viewModel.navigationCommand
    )
    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(it)
    ) {
        Column(
            modifier = Modifier.align(Alignment.Center),
            verticalArrangement = Arrangement.spacedBy(MaterialTheme.spacing.normalSpacing)
        ) {
            Text(
                text = "CHAT"
            )
            Button(onClick = { viewModel.navigateToChatFirstScreen() }) {
                Text(text = "Next screen")
            }
        }
    }
}