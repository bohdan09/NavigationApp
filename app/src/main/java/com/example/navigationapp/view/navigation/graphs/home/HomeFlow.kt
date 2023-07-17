package com.example.navigationapp.view.navigation.graphs.home

import com.example.navigationapp.navigation.NavFlow
import com.example.navigationapp.navigation.NavFlowRoute

sealed class HomeFlow(
    override val flowRoute: NavFlowRoute,
    override val label: String,
    override val argKey1: String? = null,
    override val argKey2: String? = null,
    override val argKey3: String? = null
) : NavFlow() {
    object HomeScreen : HomeFlow(NavFlowRoute("HomeScreen"), "HomeScreen")

    object HomeFirst : HomeFlow(NavFlowRoute("HomeFirst"), "HomeFirst", "inputField")
}
