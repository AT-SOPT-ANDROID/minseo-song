package org.sopt.at.core.navigation

import kotlinx.serialization.Serializable

sealed interface AuthRoute{
    @Serializable
    data object SignIn: AuthRoute
    @Serializable
    data object SignUp: AuthRoute
    @Serializable
    data object My: AuthRoute
}

sealed interface MainTabRoute{
    @Serializable
    data object Home: MainTabRoute
    @Serializable
    data object Shorts: MainTabRoute
    @Serializable
    data object Live: MainTabRoute
    @Serializable
    data object Search: MainTabRoute
    @Serializable
    data object History: MainTabRoute
}