package org.sopt.at.presentation.ui.signin.navigation

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import org.sopt.at.core.navigation.AuthRoute
import org.sopt.at.presentation.ui.signin.SignInRoute
import org.sopt.at.presentation.ui.signup.navigation.navigateToSignUp

fun NavController.navigateToSignIn() {
    navigate(AuthRoute.SignIn)
}

fun NavGraphBuilder.signInNavGraph(
    padding: PaddingValues,
    onNavigateToHome: () -> Unit,
    navController: NavController
) {
    composable<AuthRoute.SignIn> {
        SignInRoute(
            navigateToSignUp = { navController.navigateToSignUp() },
            navigateToHome = onNavigateToHome,
            modifier = Modifier.padding(padding)
        )
    }
}