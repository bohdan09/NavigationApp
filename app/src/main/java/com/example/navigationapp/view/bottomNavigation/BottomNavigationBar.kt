package com.example.navigationapp.view.bottomNavigation

import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.selection.selectableGroup
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.contentColorFor
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavOptions
import androidx.navigation.compose.currentBackStackEntryAsState
import com.example.navigationapp.navigation.AppNavigator
import com.example.navigationapp.view.theme.GrayishWhite

@Composable
fun BottomNavigationBar(
    appNavigator: AppNavigator,
    items: Collection<BottomNavFlowItem>,
) {
    val navController = appNavigator.navController
    BottomNavigationBar(
        backgroundColor = Color.White,
        contentColor = Color.Black
    ) {
        val navBackStackEntry by navController.currentBackStackEntryAsState()
        val currentDestination = navBackStackEntry?.destination
        items.forEach { item ->
            val selected =
                currentDestination?.hierarchy?.any { it.route == item.flowRoute.route } == true
            BottomNavigationItems(item, selected) {
                appNavigator.navigateToFlow(item, bottomNavigationNavOptions(navController))
            }
        }
    }
}

@Composable
fun BottomNavigationBar(
    modifier: Modifier = Modifier,
    backgroundColor: Color = Color.Red,
    contentColor: Color = contentColorFor(backgroundColor),
    content: @Composable RowScope.() -> Unit
) {
    Surface(
        color = backgroundColor,
        contentColor = contentColor,
        modifier = modifier
    ) {
        Row(
            Modifier
                .fillMaxWidth()
                .height(60.dp)
                .selectableGroup(),
            horizontalArrangement = Arrangement.SpaceBetween,
            content = content
        )
    }
}

private fun bottomNavigationNavOptions(navController: NavController) = NavOptions.Builder()
    // Avoid multiple copies of the same destination when
    // reselecting the same item
    .setLaunchSingleTop(true)
    // Restore state when reselecting a previously selected item
    .setRestoreState(true)
    // Pop up to the start destination of the graph to
    // avoid building up a large stack of destinations
    // on the back stack as users select items
    .setPopUpTo(
        navController.graph.findStartDestination().id,
        inclusive = false,
        saveState = false
    ).build()

@Composable
private fun RowScope.BottomNavigationItems(
    item: BottomNavFlowItem,
    selected: Boolean,
    onClick: () -> Unit
) {
    val foregroundTint =
        animateColorAsState(
            targetValue = if (selected) Color.Black else Color.Gray,
            animationSpec = tween()
        )

    val backgroundTint =
        animateColorAsState(
            targetValue = if (selected) Color.White else GrayishWhite,
            animationSpec = tween()
        )

    NavigationBarItem(
        icon = {
            MenuItem(item, backgroundTint.value, foregroundTint.value)
        },
        label = {
            Label(item, foregroundTint.value, selected)
        },
        selected = selected,
        onClick = onClick
    )
}

@Composable
private fun Label(
    item: BottomNavFlowItem,
    color: Color,
    selected: Boolean
) = Text(
    text = stringResource(id = item.title),
    color = color,
    fontWeight = if (selected) FontWeight.Bold else FontWeight.Medium,
    fontSize = 7.sp
)