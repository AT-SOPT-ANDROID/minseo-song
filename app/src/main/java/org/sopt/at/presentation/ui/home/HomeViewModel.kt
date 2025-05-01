package org.sopt.at.presentation.ui.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import org.sopt.at.domain.model.HomeImage
import org.sopt.at.domain.type.TvingCategoryType
import org.sopt.at.domain.type.TvingPlatFormType
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor() : ViewModel() {
    private val _profileImage =
        MutableStateFlow<String>("https://image.tving.com/upload/profile/IG00000023_IMAGE_12.png/dims/resize/F_webp,400")
    val profileImage: StateFlow<String> = _profileImage.asStateFlow()

    private val _homeBannerImageList = MutableStateFlow<List<HomeImage>>(emptyList())
    val homeBannerImageList = _homeBannerImageList.asStateFlow()

    private val _homeTop20ImageList = MutableStateFlow<List<HomeImage>>(emptyList())
    val homeTop20ImageList = _homeTop20ImageList.asStateFlow()

    private val _homeNowPlayingImageList = MutableStateFlow<List<HomeImage>>(emptyList())
    val homeNowPlayingImageList = _homeNowPlayingImageList.asStateFlow()

    private val _categoryList = MutableStateFlow(TvingCategoryType.entries)
    val categoryList = _categoryList.asStateFlow()

    private val _selectedCategory = MutableStateFlow<TvingCategoryType?>(null)
    val selectedCategory = _selectedCategory.asStateFlow()

    private val _currentBannerPage = MutableStateFlow(0)
    val currentBannerPage = _currentBannerPage.asStateFlow()

    private val _platFormList = MutableStateFlow(TvingPlatFormType.entries)
    val platFormList = _platFormList.asStateFlow()

    init {
        loadHomeImages()
        startAutoScroll()
    }

    fun selectCategory(category: TvingCategoryType?) {
        _selectedCategory.value = category
        _currentBannerPage.value = 0

        when (category) {
            TvingCategoryType.ANIMATION -> _homeBannerImageList.value = loadAnimationBannerImageList()
            TvingCategoryType.VARIETY -> _homeBannerImageList.value = loadVarietyBannerImageList()
            TvingCategoryType.DRAMA -> _homeBannerImageList.value = loadDramaBannerImageList()
            TvingCategoryType.SPORTS -> _homeBannerImageList.value = loadSportsBannerImageList()
            else -> _homeBannerImageList.value = loadHomeBannerImageList()
        }
    }

    fun setCurrentBannerPage(page: Int) {
        _currentBannerPage.value = page
    }

    private fun loadHomeImages() {
        viewModelScope.launch {
            _homeBannerImageList.value = loadHomeBannerImageList()
            _homeTop20ImageList.value = loadHomeTop20ImageList()
            _homeNowPlayingImageList.value = loadHomeNowPlayingImageList()
        }
    }

    private fun startAutoScroll() {
        viewModelScope.launch {
            while (true) {
                delay(3000)
                val next =
                    (_currentBannerPage.value + 1) % (_homeBannerImageList.value.size.coerceAtLeast(
                        1
                    ))
                _currentBannerPage.value = next
            }
        }
    }

    private fun loadHomeBannerImageList(): List<HomeImage> = listOf(
        HomeImage(
            title = "명탐정 코난20",
            imageUrl = "https://image.tving.com/ntgs/contents/CTC/caip/CAIP0900/ko/20231026/0525/P001635842.jpg/dims/resize/F_webp,400"
        ),
        HomeImage(
            title = "짱구는 못말려 더 비기닝",
            imageUrl = "https://image.tving.com/ntgs/contents/CTC/caip/CAIP0900/ko/20210412/P001461865.jpg/dims/resize/F_webp,400"
        ),
        HomeImage(
            title = "짱구는 못말려 X파일",
            imageUrl = "https://image.tving.com/ntgs/contents/CTC/caip/CAIP0900/ko/20151224/P000228200.jpg/dims/resize/F_webp,400"
        ),
        HomeImage(
            title = "진격 거인중학교",
            imageUrl = "https://image.tving.com/ntgs/contents/CTC/caip/CAIP0900/ko/20151002/P000195047.jpg/dims/resize/F_webp,400"
        ),
        HomeImage(
            title = "진격의 거인",
            imageUrl = "https://image.tving.com/ntgs/contents/CTC/caip/CAIP0900/ko/20200902/P001319056.jpg/dims/resize/F_webp,400"
        ),
        HomeImage(
            title = "꿈빛 파티시엘",
            imageUrl = "https://image.tving.com/ntgs/contents/CTC/caip/CAIP0900/ko/20160131/P000241379.jpg/dims/resize/F_webp,400"
        )
    )

    private fun loadHomeTop20ImageList(): List<HomeImage> = listOf(
        HomeImage(
            title = "나는 솔로",
            imageUrl = "https://image.tving.com/ntgs/contents/CTC/caip/CAIP0900/ko/20231025/1510/P001492081.jpg/dims/resize/F_webp,400"
        ),
        HomeImage(
            title = "전공의생활",
            imageUrl = "https://image.tving.com/ntgs/contents/CTC/caip/CAIP1140/ko/20250414/0643/P001768976.jpg/dims/resize/F_webp,400"
        ),
        HomeImage(
            title = "냉장고를 부탁해",
            imageUrl = "https://image.tving.com/ntgs/contents/CTC/caip/CAIP0900/ko/20241212/0436/P001765388.jpg/dims/resize/F_webp,400"
        ),
        HomeImage(
            title = "이혼숙려캠프",
            imageUrl = "https://image.tving.com/ntgs/contents/CTC/caip/CAIP0900/ko/20240814/1707/P001760343.jpg/dims/resize/F_webp,400"
        ),
        HomeImage(
            title = "이혼보험",
            imageUrl = "https://image.tving.com/ntgs/contents/CTC/caip/CAIP1150/ko/20250408/0916/P001769110.jpg/dims/resize/F_webp,400"
        ),
        HomeImage(
            title = "나는 솔로, 그후 사랑은 계속된다",
            imageUrl = "https://image.tving.com/ntgs/contents/CTC/caip/CAIP0900/ko/20241114/1441/P001632868.jpg/dims/resize/F_webp,400"
        ),
        HomeImage(
            title = "신병",
            imageUrl = "https://image.tving.com/ntgs/contents/CTC/caip/CAIP0900/ko/20221123/P001670538.jpg/dims/resize/F_webp,400"
        ),
        HomeImage(
            title = "국색방화",
            imageUrl = "https://image.tving.com/ntgs/contents/CTC/caip/CAIP0900/ko/20250406/2325/P001770069.jpg/dims/resize/F_webp,400"
        ),
        HomeImage(
            title = "지구마블 세계여행3",
            imageUrl = "https://image.tving.com/ntgs/contents/CTC/caip/CAIP0900/ko/20250307/0840/P001768874.jpg/dims/resize/F_webp,400"
        ),
        HomeImage(
            title = "비긴어게인",
            imageUrl = "https://image.tving.com/ntgs/contents/CTC/caip/CAIP0900/ko/20201225/P001413281.png/dims/resize/F_webp,400"
        ),
        HomeImage(
            title = "이혼보험",
            imageUrl = "https://image.tving.com/ntgs/contents/CTC/caip/CAIP0900/ko/20250317/0505/P001769110.jpg/dims/resize/F_webp,400"
        ),
        HomeImage(
            title = "크라임씬3",
            imageUrl = "https://image.tving.com/ntgs/contents/CTC/caip/CAIP0900/ko/20250423/0541/P000539639.jpg/dims/resize/F_webp,400"
        ),
        HomeImage(
            title = "크라임씬2",
            imageUrl = "https://image.tving.com/ntgs/contents/CTC/caip/CAIP0900/ko/20250423/0541/P000539640.jpg/dims/resize/F_webp,400"
        ),
        HomeImage(
            title = "전공의생활",
            imageUrl = "https://image.tving.com/ntgs/contents/CTC/caip/CAIP1120/ko/20250414/0643/P001768976.jpg/dims/resize/F_webp,400"
        ),
        HomeImage(
            title = "냉장고를 부탁해",
            imageUrl = "https://image.tving.com/ntgs/contents/CTC/caip/CAIP0900/ko/20231218/2210/P000153585.jpg/dims/resize/F_webp,400"
        ),
        HomeImage(
            title = "여고추리반3",
            imageUrl = "https://image.tving.com/ntgs/contents/CTC/caip/CAIP0900/ko/20240426/0250/P001754831.jpg/dims/resize/F_webp,400"
        ),
        HomeImage(
            title = "이혼보험",
            imageUrl = "https://image.tving.com/ntgs/contents/CTC/caip/CAIP1150/ko/20250408/0916/P001769110.jpg/dims/resize/F_webp,400"
        ),
        HomeImage(
            title = "여고추리반",
            imageUrl = "https://image.tving.com/ntgs/contents/CTC/caip/CAIP0900/ko/20231024/0950/P001433241.jpg/dims/resize/F_webp,400"
        ),
        HomeImage(
            title = "여고추리반2",
            imageUrl = "https://image.tving.com/ntgs/contents/CTC/caip/CAIP0900/ko/20231219/0047/P001537909.jpg/dims/resize/F_webp,400"
        ),
        HomeImage(
            title = "전공의생활",
            imageUrl = "https://image.tving.com/ntgs/contents/CTC/caip/CAIP0900/ko/20250320/0636/P001768976.jpg/dims/resize/F_webp,400"
        )
    )

    private fun loadHomeNowPlayingImageList(): List<HomeImage> = listOf(
        HomeImage(
            title = "바니와 오빠들",
            imageUrl = "https://image.tving.com/ntgs/contents/CTC/caip/CAIP1120/ko/20250414/0643/P001769546.jpg/dims/resize/F_webp,400"
        ),
        HomeImage(
            title = "전공의생활",
            imageUrl = "https://image.tving.com/ntgs/contents/CTC/caip/CAIP1190/ko/20250414/0643/P001768976.jpg/dims/resize/F_webp,400"
        ),
        HomeImage(
            title = "냉장고를 부탁해",
            imageUrl = "https://image.tving.com/ntgs/contents/CTC/caip/CAIP0900/ko/20241212/0436/P001765388.jpg/dims/resize/F_webp,400"
        ),
        HomeImage(
            title = "이혼숙려캠프",
            imageUrl = "https://image.tving.com/ntgs/contents/CTC/caip/CAIP0900/ko/20240814/1707/P001760343.jpg/dims/resize/F_webp,400"
        ),
        HomeImage(
            title = "이혼보험",
            imageUrl = "https://image.tving.com/ntgs/contents/CTC/caip/CAIP1150/ko/20250408/0916/P001769110.jpg/dims/resize/F_webp,400"
        ),
        HomeImage(
            title = "나는 솔로, 그후 사랑은 계속된다",
            imageUrl = "https://image.tving.com/ntgs/contents/CTC/caip/CAIP0900/ko/20241114/1441/P001632868.jpg/dims/resize/F_webp,400"
        ),
        HomeImage(
            title = "신병",
            imageUrl = "https://image.tving.com/ntgs/contents/CTC/caip/CAIP0900/ko/20221123/P001670538.jpg/dims/resize/F_webp,400"
        ),
        HomeImage(
            title = "뭉쳐야찬다4",
            imageUrl = "https://image.tving.com/ntgs/contents/CTC/caip/CAIP0900/ko/20250405/2150/P001769763.jpg/dims/resize/F_webp,400"
        ),
        HomeImage(
            title = "지구마블 세계여행3",
            imageUrl = "https://image.tving.com/ntgs/contents/CTC/caip/CAIP0900/ko/20250307/0840/P001768874.jpg/dims/resize/F_webp,400"
        ),
        HomeImage(
            title = "길바닥 밥장사",
            imageUrl = "https://image.tving.com/ntgs/contents/CTC/caip/CAIP0900/ko/20250407/1455/P001769890.jpg/dims/resize/F_webp,400"
        ),
        HomeImage(
            title = "이혼보험",
            imageUrl = "https://image.tving.com/ntgs/contents/CTC/caip/CAIP0900/ko/20250317/0505/P001769110.jpg/dims/resize/F_webp,400"
        ),
        HomeImage(
            title = "크라임씬3",
            imageUrl = "https://image.tving.com/ntgs/contents/CTC/caip/CAIP0900/ko/20250423/0541/P000539639.jpg/dims/resize/F_webp,400"
        ),
        HomeImage(
            title = "크라임씬2",
            imageUrl = "https://image.tving.com/ntgs/contents/CTC/caip/CAIP0900/ko/20250423/0541/P000539640.jpg/dims/resize/F_webp,400"
        ),
        HomeImage(
            title = "전공의생활",
            imageUrl = "https://image.tving.com/ntgs/contents/CTC/caip/CAIP1120/ko/20250414/0643/P001768976.jpg/dims/resize/F_webp,400"
        ),
        HomeImage(
            title = "냉장고를 부탁해",
            imageUrl = "https://image.tving.com/ntgs/contents/CTC/caip/CAIP0900/ko/20231218/2210/P000153585.jpg/dims/resize/F_webp,400"
        ),
        HomeImage(
            title = "여고추리반3",
            imageUrl = "https://image.tving.com/ntgs/contents/CTC/caip/CAIP0900/ko/20240426/0250/P001754831.jpg/dims/resize/F_webp,400"
        ),
        HomeImage(
            title = "이혼보험",
            imageUrl = "https://image.tving.com/ntgs/contents/CTC/caip/CAIP1150/ko/20250408/0916/P001769110.jpg/dims/resize/F_webp,400"
        ),
        HomeImage(
            title = "여고추리반",
            imageUrl = "https://image.tving.com/ntgs/contents/CTC/caip/CAIP0900/ko/20231024/0950/P001433241.jpg/dims/resize/F_webp,400"
        ),
        HomeImage(
            title = "여고추리반2",
            imageUrl = "https://image.tving.com/ntgs/contents/CTC/caip/CAIP0900/ko/20231219/0047/P001537909.jpg/dims/resize/F_webp,400"
        ),
        HomeImage(
            title = "전공의생활",
            imageUrl = "https://image.tving.com/ntgs/contents/CTC/caip/CAIP0900/ko/20250320/0636/P001768976.jpg/dims/resize/F_webp,400"
        )
    )

    private fun loadAnimationBannerImageList(): List<HomeImage> = listOf(
        HomeImage(
            title = "뽀로로 극장판 바닷속 대모험",
            imageUrl = "https://image.tving.com/ntgs/contents/CTC/caim/CAIM2100/ko/20250307/0425/M000378436.jpg/dims/resize/F_webp,400"
        ),
        HomeImage(
            title = "명탐정 코난 100만 어쩌고 펜타그램",
            imageUrl = "https://image.tving.com/ntgs/contents/CTC/caim/CAIM2100/ko/20250113/0420/M000377909.jpg/dims/resize/F_webp,400"
        ),
        HomeImage(
            title = "짱구는 못말려 동물소환닌자배꼽수비대",
            imageUrl = "https://image.tving.com/ntgs/contents/CTC/caim/CAIM1130/ko/20241212/0022/M000374462.jpg/dims/resize/F_webp,400"
        ),
        HomeImage(
            title = "짱구는 못말려 수수께끼! 꽃피는 천하떡잎학교",
            imageUrl = "https://image.tving.com/ntgs/contents/CTC/caim/CAIM1160/ko/20241128/0504/M000370074.jpg/dims/resize/F_webp,400"
        ),
        HomeImage(
            title = "명탐정 코난 흑철의 어영",
            imageUrl = "https://image.tving.com/ntgs/contents/CTC/caim/CAIM2100/ko/20240202/0700/M000376657.jpg/dims/resize/F_webp,400"
        ),
        HomeImage(
            title = "하이큐",
            imageUrl = "https://image.tving.com/ntgs/contents/CTC/caim/CAIM2100/ko/20250312/0740/M000378393.jpg/dims/resize/F_webp,400"
        )
    )

    private fun loadVarietyBannerImageList(): List<HomeImage> = listOf(
        HomeImage(
            title = "이혼숙려캠프",
            imageUrl = "https://image.tving.com/ntgs/contents/CTC/caip/CAIP0900/ko/20240814/1707/P001760343.jpg/dims/resize/F_webp,400"
        ),
        HomeImage(
            title = "나는 솔로, 그 후 사랑은 계속된다",
            imageUrl = "https://image.tving.com/ntgs/contents/CTC/caip/CAIP0900/ko/20241114/1441/P001632868.jpg/dims/resize/F_webp,400"
        ),
        HomeImage(
            title = "나는 솔로",
            imageUrl = "https://image.tving.com/ntgs/contents/CTC/caip/CAIP0900/ko/20231025/1510/P001492081.jpg/dims/resize/F_webp,400"
        ),
        HomeImage(
            title = "냉장고를 부탁해",
            imageUrl = "https://image.tving.com/ntgs/contents/CTC/caip/CAIP0900/ko/20241212/0436/P001765388.jpg/dims/resize/F_webp,400"
        ),
        HomeImage(
            title = "지구마불 세계여행3",
            imageUrl = "https://image.tving.com/ntgs/contents/CTC/caip/CAIP0900/ko/20250307/0840/P001768874.jpg/dims/resize/F_webp,400"
        ),
        HomeImage(
            title = "하트페어링",
            imageUrl = "https://image.tving.com/ntgs/contents/CTC/caip/CAIP0900/ko/20250307/1535/P001768488.jpg/dims/resize/F_webp,400"
        )
    )

    private fun loadDramaBannerImageList(): List<HomeImage> = listOf(
        HomeImage(
            title = "전공의생활",
            imageUrl = "https://image.tving.com/ntgs/contents/CTC/caip/CAIP0900/ko/20250320/0636/P001768976.jpg/dims/resize/F_webp,400"
        ),
        HomeImage(
            title = "이혼보험",
            imageUrl = "https://image.tving.com/ntgs/contents/CTC/caip/CAIP1160/ko/20250408/0916/P001769110.jpg/dims/resize/F_webp,400"
        ),
        HomeImage(
            title = "신병",
            imageUrl = "https://image.tving.com/ntgs/contents/CTC/caip/CAIP0900/ko/20221123/P001670538.jpg/dims/resize/F_webp,400"
        ),
        HomeImage(
            title = "국색방화",
            imageUrl = "https://image.tving.com/ntgs/contents/CTC/caip/CAIP0900/ko/20250406/2325/P001770069.jpg/dims/resize/F_webp,400"
        ),
        HomeImage(
            title = "슬기로운 의사생활",
            imageUrl = "https://image.tving.com/ntgs/contents/CTC/caip/CAIP0900/ko/20231115/0900/P001178341.png/dims/resize/F_webp,400"
        ),
        HomeImage(
            title = "슬기로운 의사생활2",
            imageUrl = "https://image.tving.com/ntgs/contents/CTC/caip/CAIP0900/ko/20210611/P001479830.png/dims/resize/F_webp,400"
        )
    )

    private fun loadSportsBannerImageList(): List<HomeImage> = listOf(
        HomeImage(
            title = "최강야구",
            imageUrl = "https://image.tving.com/ntgs/contents/CTC/caip/CAIP0900/ko/20240415/1250/P001609758.jpg/dims/resize/F_webp,400"
        ),
        HomeImage(
            title = "뭉쳐야찬다3",
            imageUrl = "https://image.tving.com/ntgs/contents/CTC/caip/CAIP0900/ko/20240701/0835/P001747580.jpg/dims/resize/F_webp,400"
        ),
        HomeImage(
            title = "뭉쳐야쏜다",
            imageUrl = "https://image.tving.com/upload/cms/caip/CAIP0900/P001442734.jpg/dims/resize/F_webp,400"
        ),
        HomeImage(
            title = "영광을 향하여",
            imageUrl = "https://image.tving.com/ntgs/contents/CTC/caip/CAIP0900/ko/20250321/0301/P001769314.jpg/dims/resize/F_webp,400"
        ),
        HomeImage(
            title = "낫아웃",
            imageUrl = "https://image.tving.com/ntgs/contents/CTC/caim/CAIM2100/ko/20220707/M000368285.jpg/dims/resize/F_webp,400"
        ),
        HomeImage(
            title = "글러브",
            imageUrl = "https://image.tving.com/ntgs/contents/CTC/caim/CAIM1170/ko/20240216/0645/M000280334.jpg/dims/resize/F_webp,400"
        )
    )

}