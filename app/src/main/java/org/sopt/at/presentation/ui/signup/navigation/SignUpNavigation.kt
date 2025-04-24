package org.sopt.at.presentation.ui.signup.navigation

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import org.sopt.at.core.navigation.AuthRoute
import org.sopt.at.presentation.ui.signup.SignUpRoute

fun NavController.navigateToSignUp() {
    navigate(AuthRoute.SignUp)
}

fun NavGraphBuilder.signUpNavGraph(
    padding: PaddingValues,
    navController: NavController
) {
    composable<AuthRoute.SignUp> {
        SignUpRoute(
            navigateToSignIn = { navController.popBackStack() },
            modifier = Modifier.padding(padding)
        )
    }
}