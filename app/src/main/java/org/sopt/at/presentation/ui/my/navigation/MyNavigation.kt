package org.sopt.at.presentation.ui.my.navigation

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import org.sopt.at.core.navigation.AuthRoute
import org.sopt.at.presentation.ui.my.MyRoute
import org.sopt.at.presentation.ui.signin.navigation.navigateToSignIn

fun NavController.navigateToMy() {
    navigate(AuthRoute.My)
}

fun NavGraphBuilder.myNavGraph(
    padding: PaddingValues,
    navController: NavController
) {
    composable<AuthRoute.My> {
        MyRoute(
            navigateToBack = { navController.popBackStack() },
            navigateToSignIn = { navController.navigateToSignIn() },
            modifier = Modifier.padding(padding)
        )
    }
}