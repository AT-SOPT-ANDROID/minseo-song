package org.sopt.at.presentation.ui.home

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import org.sopt.at.domain.model.HomeImage
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor() : ViewModel() {
    private val _profileImage =
        MutableStateFlow<String>("https://image.tving.com/upload/profile/IG00000023_IMAGE_12.png/dims/resize/F_webp,400")
    val profileImage: StateFlow<String> = _profileImage.asStateFlow()

    private val _homeBannerImageList = MutableStateFlow<List<HomeImage>>(emptyList())
    val homeBannerImageList = _homeBannerImageList.asStateFlow()

    private val _homeTop20ImageList = MutableStateFlow<List<HomeImage>>(emptyList())
    val homeTop20ImageList = _homeBannerImageList.asStateFlow()

    private val _homeNowPlayingImageList = MutableStateFlow<List<HomeImage>>(emptyList())
    val homeNowPlayingImageList = _homeBannerImageList.asStateFlow()


}