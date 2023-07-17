package com.example.navigationapp.view.bottomNavigation

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import com.example.navigationapp.navigation.NavFlow
import com.example.navigationapp.navigation.NavFlowRoute

abstract class BottomNavFlowItem(
    @DrawableRes val foregroundIcon: Int,
    @DrawableRes val backgroundIcon: Int,
    @StringRes val title: Int,
    override val flowRoute: NavFlowRoute,
    override val label: String,
    open val indicatorCount: Int? = null,
) : NavFlow()
