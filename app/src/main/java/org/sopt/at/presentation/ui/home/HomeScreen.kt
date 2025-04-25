package org.sopt.at.presentation.ui.home

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.PagerState
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.snapshotFlow
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import coil.compose.AsyncImage
import coil.request.ImageRequest
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.distinctUntilChanged
import org.sopt.at.core.component.topbar.TvingTopBar
import org.sopt.at.core.util.noRippleClickable
import org.sopt.at.domain.model.HomeImage
import org.sopt.at.domain.type.TvingCategoryType
import org.sopt.at.domain.type.TvingPlatFormType
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
    val categoryList by viewModel.categoryList.collectAsStateWithLifecycle()
    val currentBannerPage by viewModel.currentBannerPage.collectAsStateWithLifecycle()
    val platFormList by viewModel.platFormList.collectAsStateWithLifecycle()

    val pagerState = rememberPagerState(
        pageCount = { homeBannerImageList.size },
        initialPage = currentBannerPage
    )

    LaunchedEffect(currentBannerPage) {
        if (pagerState.currentPage != currentBannerPage) {
            pagerState.animateScrollToPage(currentBannerPage)
        }
    }

    LaunchedEffect(pagerState) {
        snapshotFlow { pagerState.currentPage }
            .distinctUntilChanged()
            .collectLatest { newPage ->
                viewModel.setCurrentBannerPage(newPage)
            }
    }

    HomeScreen(
        padding = padding,
        profileImage = profileImage,
        categoryList = categoryList,
        pagerState = pagerState,
        platFormList = platFormList,
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
    categoryList: List<TvingCategoryType>,
    pagerState: PagerState,
    platFormList: List<TvingPlatFormType>,
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
        item {
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
                    items(categoryList.size) {
                        val category = categoryList[it]
                        Text(
                            text = category.description,
                            color = colors.white,
                            fontSize = 18.sp,
                            modifier = Modifier
                                .noRippleClickable {}
                        )
                    }
                }
            }
        }

        item {
            HorizontalPager(
                state = pagerState,
                contentPadding = PaddingValues(horizontal = 20.dp),
                modifier = Modifier.padding(vertical = 20.dp)
            ) { index ->
                AsyncImage(
                    model = ImageRequest.Builder(LocalContext.current)
                        .data(homeBannerImageList[index].imageUrl)
                        .crossfade(true)
                        .build(),
                    contentDescription = "",
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .clip(RoundedCornerShape(8.dp))
                        .size(width = 360.dp, height = 480.dp)
                )

            }
        }

        item {
            LazyRow(
                contentPadding = PaddingValues(horizontal = 16.dp),
                horizontalArrangement = Arrangement.spacedBy(20.dp)
            ) {
                items(platFormList.size) {
                    val platForm = platFormList[it]
                    Box(
                        modifier = Modifier
                            .background(
                                color = colors.gray400,
                                shape = RoundedCornerShape(10.dp)
                            )
                            .noRippleClickable {}
                    ) {
                        AsyncImage(
                            model = ImageRequest.Builder(LocalContext.current)
                                .data(platForm.imageUrl)
                                .build(),
                            contentDescription = platForm.title,
                            modifier = Modifier
                                .padding(horizontal = 20.dp)
                                .size(80.dp)
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
            categoryList = emptyList(),
            pagerState = rememberPagerState(pageCount = { 0 }),
            platFormList = emptyList(),
            homeBannerImageList = emptyList(),
            homeTop20ImageList = emptyList(),
            homeNowPlayingImageList = emptyList(),
            navigateToMy = {}
        )
    }
}