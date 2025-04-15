package org.sopt.at.presentation.ui.my

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject

@HiltViewModel
class MyViewModel @Inject constructor() : ViewModel() {
    private val _profileImage = MutableStateFlow<String>("https://image.tving.com/upload/profile/IG00000023_IMAGE_12.png/dims/resize/F_webp,400")
    val profileImage: StateFlow<String> = _profileImage.asStateFlow()
}