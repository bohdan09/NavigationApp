package com.example.navigationapp.view.screens.chats.viewmodel

import com.example.navigationapp.navigation.command.NavigationCommand
import com.example.navigationapp.view.navigation.graphs.chat.ChatFlow
import com.example.navigationapp.viewmodel.BaseViewModel

class ChatScreenViewModel : BaseViewModel() {

    fun navigateToChatFirstScreen() {
        launch(ioContext) {
            _navigationCommand.emit(NavigationCommand.To(ChatFlow.ChatFirstScreen))
        }
    }
}