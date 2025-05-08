package org.sopt.at.presentation.ui.my

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import org.sopt.at.domain.usecase.GetMyNickNameUseCase
import javax.inject.Inject

@HiltViewModel
class MyViewModel @Inject constructor(
    private val getMyNickNameUseCase: GetMyNickNameUseCase
) : ViewModel() {
    private val _profileImage =
        MutableStateFlow<String>("https://image.tving.com/upload/profile/IG00000023_IMAGE_12.png/dims/resize/F_webp,400")
    val profileImage: StateFlow<String> = _profileImage.asStateFlow()

    private val _nickname = MutableStateFlow<String>("")
    val nickname: StateFlow<String> = _nickname.asStateFlow()

    fun getMyNickName(
        userId: Long
    ) {
        viewModelScope.launch {
            getMyNickNameUseCase(userId)
                .onSuccess { response ->
                    _nickname.value = response.nickname
                }
        }
    }
}