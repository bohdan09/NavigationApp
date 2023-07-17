package com.example.navigationapp.navigation.util

import androidx.navigation.NavBackStackEntry
import com.example.navigationapp.navigation.NavFlow
import com.example.navigationapp.navigation.NavFlowRoute
import com.example.navigationapp.navigation.plusParam

/**
 * Create a route with keys and values
 *
 * Can be used to pass params to the navigation
 */
fun NavFlow.routeWithParamsAndValues(
    vararg arg: Pair<String, Any>?
): String {
    var route = flowRoute.route
    arg.filterNotNull().forEach {
        route = route.plus("/").plus(it.first + "=").plus(it.second)
    }
    return route
}

/**
 * Create a route only with keys
 *
 * Can be used as a navigation route.
 * Use not null keys that we have in [NavFlow]
 */
fun NavFlow.routeWithKeys(): NavFlowRoute {
    var route: String = flowRoute.route
    argKey1?.let {
        route = route.plusParam(it)
    }
    argKey2?.let {
        route = route.plusParam(it)
    }
    argKey3?.let {
        route = route.plusParam(it)
    }
    return NavFlowRoute(route)
}

/**
 * Get argument from the [NavBackStackEntry] by the first key in [NavFlow]
 */
inline fun <reified T : Any> NavBackStackEntry.firstKeyValue(
    navFlow: NavFlow
): T? {
    return keyValue(navFlow.argKey1)
}

/**
 * Get argument from the [NavBackStackEntry] by the first second in [NavFlow]
 */
inline fun <reified T : Any> NavBackStackEntry.secondKeyValue(
    navFlow: NavFlow
): T? {
    return keyValue(navFlow.argKey2)
}

/**
 * Get argument from the [NavBackStackEntry] by the third key in [NavFlow]
 */
inline fun <reified T : Any> NavBackStackEntry.thirdKeyValue(
    navFlow: NavFlow
): T? {
    return keyValue(navFlow.argKey3)
}

inline fun <reified T : Any> NavBackStackEntry.keyValue(
    key: String?
) = arguments?.get(key) as? T
