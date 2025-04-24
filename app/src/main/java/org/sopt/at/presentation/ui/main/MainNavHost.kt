package org.sopt.at.presentation.ui.main

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import org.sopt.at.presentation.ui.history.navigation.historyNavGraph
import org.sopt.at.presentation.ui.home.navigation.homeNavGraph
import org.sopt.at.presentation.ui.live.navigation.liveNavGraph
import org.sopt.at.presentation.ui.my.navigation.myNavGraph
import org.sopt.at.presentation.ui.search.navigation.searchNavGraph
import org.sopt.at.presentation.ui.shorts.navigation.shortsNavGraph
import org.sopt.at.presentation.ui.signin.navigation.signInNavGraph
import org.sopt.at.presentation.ui.signup.navigation.signUpNavGraph
import org.sopt.at.ui.theme.TvingTheme.colors

@Composable
fun MainNavHost(
    navigator: MainNavigator,
    padding: PaddingValues,
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier
            .fillMaxSize()
            .background(color = colors.black)
    ) {
        NavHost(
            navController = navigator.navController,
            startDestination = navigator.startDestination
        ) {
            signInNavGraph(
                padding = padding,
                onNavigateToHome = navigator::navigateToHome,
                navController = navigator.navController
            )
            signUpNavGraph(
                padding = padding,
                navController = navigator.navController
            )
            myNavGraph(
                padding = padding,
                navController = navigator.navController
            )
            homeNavGraph(padding)
            liveNavGraph(padding)
            searchNavGraph(padding)
            historyNavGraph(padding)
            shortsNavGraph(padding)
        }
    }
}