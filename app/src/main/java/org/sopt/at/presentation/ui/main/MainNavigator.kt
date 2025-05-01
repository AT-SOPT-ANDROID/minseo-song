package org.sopt.at.presentation.ui.main

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.navigation.NavDestination
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.NavOptions
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navOptions
import org.sopt.at.core.navigation.AuthRoute
import org.sopt.at.core.navigation.MainTabRoute
import org.sopt.at.presentation.ui.history.navigation.navigateToHistory
import org.sopt.at.presentation.ui.home.navigation.navigateToHome
import org.sopt.at.presentation.ui.live.navigation.navigateToLive
import org.sopt.at.presentation.ui.search.navigation.navigateToSearch
import org.sopt.at.presentation.ui.shorts.navigation.navigateToShorts

class MainNavigator(
    val navController: NavHostController
) {
    private val currentDestination: NavDestination?
        @Composable get() = navController
            .currentBackStackEntryAsState().value?.destination

//    val startDestination = AuthRoute.SignIn
    val startDestination = MainTabRoute.Home

    val currentTab: MainTab?
        @Composable get() = MainTab.entries.find { tab ->
            when (tab.route) {
                else -> currentDestination?.route == tab.route::class.qualifiedName
            }
        }

    fun navigate(tab: MainTab) {
        val navOptions = navOptions {
            popUpTo(MainTab.HOME.route) {
                inclusive = false
            }
            launchSingleTop = true
            restoreState = true
        }

        when (tab) {
            MainTab.HOME -> navController.navigateToHome(navOptions)
            MainTab.LIVE -> navController.navigateToLive(navOptions)
            MainTab.SEARCH -> navController.navigateToSearch(navOptions)
            MainTab.HISTORY -> navController.navigateToHistory(navOptions)
            MainTab.SHORTS -> navController.navigateToShorts(navOptions)
        }
    }

    fun navigateToHome(navOptions: NavOptions? = null) {
        navController.navigateToHome(
            navOptions ?: navOptions {
                popUpTo(navController.graph.findStartDestination().id) {
                    inclusive = true
                }
                launchSingleTop = true
            }
        )
    }

    private fun popBackStack() {
        navController.popBackStack()
    }

    @Composable
    fun shouldShowBottomBar() = MainTab.contains {
        currentDestination?.route == it::class.qualifiedName
    }
}

@Composable
fun rememberMainNavigator(
    navController: NavHostController = rememberNavController(),
): MainNavigator = remember(navController) {
    MainNavigator(navController)
}