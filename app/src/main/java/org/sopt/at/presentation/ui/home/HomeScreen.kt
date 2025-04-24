package org.sopt.at.presentation.ui.home

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import org.sopt.at.core.component.topbar.TvingTopBar
import org.sopt.at.ui.theme.TvingTheme

@Composable
fun HomeRoute(
    padding: PaddingValues,
    navigateToMy: () -> Unit,
    viewModel: HomeViewModel = hiltViewModel()
) {
    val profileImage by viewModel.profileImage.collectAsStateWithLifecycle()

    HomeScreen(
        padding = padding,
        profileImage = profileImage,
        navigateToMy = navigateToMy
    )
}

@Composable
private fun HomeScreen(
    padding: PaddingValues,
    profileImage: String,
    navigateToMy: () -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(padding)
    ) {
        TvingTopBar(
            profileImage = profileImage,
            onProfileClick = navigateToMy
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun PreviewHistoryScreen() {
    TvingTheme {
        HomeScreen(
            padding = PaddingValues(),
            profileImage = "",
            navigateToMy = {}
        )
    }
}