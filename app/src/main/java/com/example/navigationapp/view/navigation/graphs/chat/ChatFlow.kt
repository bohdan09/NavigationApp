package com.example.navigationapp.view.navigation.graphs.chat

import com.example.navigationapp.navigation.NavFlow
import com.example.navigationapp.navigation.NavFlowRoute

sealed class ChatFlow(
    override val flowRoute: NavFlowRoute,
    override val label: String,
    override val argKey1: String? = null,
    override val argKey2: String? = null,
    override val argKey3: String? = null
) : NavFlow() {
    object ChatScreen : ChatFlow(NavFlowRoute("ChatScreen"), "ChatScreen")
    object ChatFirstScreen : ChatFlow(NavFlowRoute("ChatFirstScreen"), "ChatFirstScreen")
}
