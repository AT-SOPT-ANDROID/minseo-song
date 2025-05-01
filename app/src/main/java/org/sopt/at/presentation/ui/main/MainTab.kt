package org.sopt.at.presentation.ui.main

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.runtime.Composable
import org.sopt.at.R
import org.sopt.at.core.navigation.MainTabRoute

enum class MainTab(
    @DrawableRes val defaultIconResId: Int,
    @StringRes val descriptionResId: Int,
    val route: MainTabRoute
) {
    HOME(
        defaultIconResId = R.drawable.ic_bottom_tab_home,
        descriptionResId = R.string.bottom_bar_home,
        route = MainTabRoute.Home
    ),
    SHORTS(
        defaultIconResId = R.drawable.ic_bottom_tab_shorts,
        descriptionResId = R.string.bottom_bar_shorts,
        route = MainTabRoute.Shorts
    ),
    LIVE(
        defaultIconResId = R.drawable.ic_bottom_tab_live,
        descriptionResId = R.string.bottom_bar_live,
        route = MainTabRoute.Live
    ),
    SEARCH(
        defaultIconResId = R.drawable.ic_bottom_tab_search,
        descriptionResId = R.string.bottom_bar_search,
        route = MainTabRoute.Search
    ),
    HISTORY(
        defaultIconResId = R.drawable.ic_bottom_tab_history,
        descriptionResId = R.string.bottom_bar_history,
        route = MainTabRoute.History
    );

    companion object {
        @Composable
        fun contains(predicate: @Composable (MainTabRoute) -> Boolean): Boolean {
            return entries.map { it.route }.any { predicate(it) }
        }
    }
}