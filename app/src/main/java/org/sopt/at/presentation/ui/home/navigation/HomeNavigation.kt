package org.sopt.at.presentation.ui.home.navigation

import androidx.compose.foundation.layout.PaddingValues
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import org.sopt.at.core.navigation.MainTabRoute
import org.sopt.at.presentation.ui.home.HomeRoute
import org.sopt.at.presentation.ui.my.navigation.navigateToMy

fun NavController.navigateToHome(navOptions: NavOptions) {
    navigate(MainTabRoute.Home, navOptions)
}

fun NavGraphBuilder.homeNavGraph(
    padding: PaddingValues,
    navController: NavController
) {
    composable<MainTabRoute.Home> {
        HomeRoute(
            padding = padding,
            navigateToMy = { navController.navigateToMy() }
        )
    }
}