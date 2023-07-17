package com.example.navigationapp.view.bottomNavigation

import com.example.navigationapp.viewmodel.BaseViewModel

class BottomNavigationTabViewModel(
) : BaseViewModel() {

    val menuItems = listOf(
        BottomNavItemsFlow.Home,
        BottomNavItemsFlow.Chats,
        BottomNavItemsFlow.Profile
    )
}
