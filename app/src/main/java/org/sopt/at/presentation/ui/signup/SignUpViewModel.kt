package org.sopt.at.presentation.ui.signup

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import org.sopt.at.core.util.KeyStorage
import org.sopt.at.domain.model.SignUpInfo
import org.sopt.at.domain.usecase.PostSignUpUseCase
import javax.inject.Inject

@HiltViewModel
class SignUpViewModel @Inject constructor(
    private val postSignUpUseCase: PostSignUpUseCase
) : ViewModel() {
    private val _id = MutableStateFlow<String>("")
    val id = _id.asStateFlow()

    private val _password = MutableStateFlow<String>("")
    val password = _password.asStateFlow()

    private val _nickname = MutableStateFlow<String>("")
    val nickname = _nickname.asStateFlow()

    private val _signUpState = MutableStateFlow<Int>(1)
    val signUpState = _signUpState.asStateFlow()

    fun updateId(newId: String) {
        _id.value = newId
    }

    fun updatePassword(newPassword: String) {
        _password.value = newPassword
    }

    fun updateNickname(newNickname: String) {
        _nickname.value = newNickname
    }

    fun nextStep() {
        if (_signUpState.value != 3) _signUpState.value ++
    }

    fun previousStep() {
        if (_signUpState.value != 1) _signUpState.value --

    }

    fun isIdValid(id: String): Boolean {
        return KeyStorage.ID_REGEX.matches(id)
    }

    fun isPasswordValid(password: String): Boolean {
        return KeyStorage.PASSWORD_REGEX.matches(password)
    }

    fun postSignUp(
        onSuccess: () -> Unit,
        onFailure: () -> Unit
    ){
        viewModelScope.launch {
            val signUpInfo = SignUpInfo(
                loginId = id.value,
                password = password.value,
                nickname = nickname.value
            )

            postSignUpUseCase(signUpInfo)
                .onSuccess {
                    clearData()
                    onSuccess()
                }
                .onFailure {
                    onFailure()
                }
        }
    }

    fun clearData() {
        _id.value = ""
        _password.value = ""
        _signUpState.value = 1
    }
}