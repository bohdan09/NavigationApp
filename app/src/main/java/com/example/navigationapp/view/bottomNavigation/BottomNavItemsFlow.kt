package com.example.navigationapp.view.bottomNavigation

import com.example.navigationapp.R
import com.example.navigationapp.navigation.toFlowRoute

sealed class BottomNavItemsFlow {
    object Home :
        BottomNavFlowItem(
            R.drawable.ic_home_foreground,
            R.drawable.ic_home_background,
            R.string.bottom_nav_home,
            "CustomerHome".toFlowRoute(),
            "Home"
        )

    object Chats :
        BottomNavFlowItem(
            R.drawable.ic_chat_foreground,
            R.drawable.ic_chat_background,
            R.string.bottom_nav_chats,
            "CustomerChats".toFlowRoute(),
            "Chats"
        )

    object Profile :
        BottomNavFlowItem(
            R.drawable.ic_profile_foreground,
            R.drawable.ic_profile_background,
            R.string.bottom_nav_profile,
            "CustomerProfile".toFlowRoute(),
            "Profile"
        )
}
