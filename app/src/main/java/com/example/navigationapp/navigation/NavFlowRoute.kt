package com.example.navigationapp.navigation

@JvmInline
value class NavFlowRoute(val route: String)

fun String.toFlowRoute() = NavFlowRoute(this)
