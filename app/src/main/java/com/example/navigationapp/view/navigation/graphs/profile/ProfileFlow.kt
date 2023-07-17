package com.example.navigationapp.view.navigation.graphs.profile

import com.example.navigationapp.navigation.NavFlow
import com.example.navigationapp.navigation.NavFlowRoute

sealed class ProfileFlow(
    override val flowRoute: NavFlowRoute,
    override val label: String,
    override val argKey1: String? = null,
    override val argKey2: String? = null,
    override val argKey3: String? = null
) : NavFlow() {
    object ProfileScreen : ProfileFlow(NavFlowRoute("ProfileScreen"), "ProfileScreen")
}
