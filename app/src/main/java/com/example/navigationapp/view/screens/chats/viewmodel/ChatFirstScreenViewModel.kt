package com.example.navigationapp.view.screens.chats.viewmodel

import com.example.navigationapp.navigation.command.NavigationCommand
import com.example.navigationapp.viewmodel.BaseViewModel

class ChatFirstScreenViewModel : BaseViewModel() {

    fun navigateBack() {
        launch(ioContext) {
            _navigationCommand.emit(NavigationCommand.Back)
        }
    }
}