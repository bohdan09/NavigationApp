package com.example.navigationapp.navigation.command

import androidx.navigation.NavOptionsBuilder
import com.example.navigationapp.navigation.NavFlow

sealed class NavigationCommand {
    /**
     * @param direction to which navigation should be run
     */
    data class To(
        val direction: NavFlow,
        val builder: NavOptionsBuilder.() -> Unit = {},
    ) : NavigationCommand()

    /**
     * Back navigation command
     */
    object Back : NavigationCommand()
}
