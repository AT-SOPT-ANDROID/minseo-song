package org.sopt.at.presentation.ui.home

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import org.sopt.at.core.component.topbar.TvingTopBar
import org.sopt.at.domain.model.HomeImage
import org.sopt.at.domain.type.TvingCategoryType
import org.sopt.at.ui.theme.TvingTheme
import org.sopt.at.ui.theme.TvingTheme.colors

@Composable
fun HomeRoute(
    padding: PaddingValues,
    navigateToMy: () -> Unit,
    viewModel: HomeViewModel = hiltViewModel()
) {
    val profileImage by viewModel.profileImage.collectAsStateWithLifecycle()
    val homeBannerImageList by viewModel.homeBannerImageList.collectAsStateWithLifecycle()
    val homeTop20ImageList by viewModel.homeTop20ImageList.collectAsStateWithLifecycle()
    val homeNowPlayingImageList by viewModel.homeNowPlayingImageList.collectAsStateWithLifecycle()

    HomeScreen(
        padding = padding,
        profileImage = profileImage,
        homeBannerImageList = homeBannerImageList,
        homeTop20ImageList = homeTop20ImageList,
        homeNowPlayingImageList = homeNowPlayingImageList,
        navigateToMy = navigateToMy
    )
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
private fun HomeScreen(
    padding: PaddingValues,
    profileImage: String,
    homeBannerImageList: List<HomeImage>,
    homeTop20ImageList: List<HomeImage>,
    homeNowPlayingImageList: List<HomeImage>,
    navigateToMy: () -> Unit
) {
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(padding)
    ) {
        item{
            TvingTopBar(
                profileImage = profileImage,
                onProfileClick = navigateToMy
            )
        }

        stickyHeader {
            Row(
                modifier = Modifier
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.Center
            ) {
                LazyRow(
                    contentPadding = PaddingValues(horizontal = 16.dp),
                    horizontalArrangement = Arrangement.spacedBy(20.dp)
                ) {
                    items(
                        count = TvingCategoryType.entries.size,
                        key = { item -> TvingCategoryType.entries[item].name }
                    ) {
                        Text(
                            text = TvingCategoryType.entries[it].description,
                            color = colors.white,
                            fontSize = 18.sp
                        )
                    }
                }
            }
        }


    }
}

@Preview(showBackground = true)
@Composable
private fun PreviewHistoryScreen() {
    TvingTheme {
        HomeScreen(
            padding = PaddingValues(),
            profileImage = "",
            homeBannerImageList = emptyList(),
            homeTop20ImageList = emptyList(),
            homeNowPlayingImageList = emptyList(),
            navigateToMy = {}
        )
    }
}