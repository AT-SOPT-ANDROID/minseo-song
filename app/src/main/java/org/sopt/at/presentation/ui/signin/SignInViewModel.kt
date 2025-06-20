package org.sopt.at.presentation.ui.signin

import android.content.Context
import android.content.SharedPreferences
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import org.sopt.at.domain.model.SignInRequestInfo
import org.sopt.at.domain.usecase.PostSignInUseCase
import javax.inject.Inject
import androidx.core.content.edit

@HiltViewModel
class SignInViewModel @Inject constructor(
    private val postSignInUseCase: PostSignInUseCase
) : ViewModel() {
    private lateinit var sharedPreferences: SharedPreferences

    private val _id = MutableStateFlow<String>("")
    val id: StateFlow<String> = _id.asStateFlow()

    private val _password = MutableStateFlow<String>("")
    val password: StateFlow<String> = _password.asStateFlow()

    fun initPrefs(context: Context) {
        sharedPreferences = context.getSharedPreferences("user_prefs", Context.MODE_PRIVATE)
    }

    fun updateId(id: String) {
        _id.value = id
    }

    fun updatePassword(password: String) {
        _password.value = password
    }

    fun postSignIn(
        onSuccess: () -> Unit,
        onFailure: (String) -> Unit
    ) {
        viewModelScope.launch {
            val request = SignInRequestInfo(
                loginId = id.value,
                password = password.value
            )

            postSignInUseCase(request)
                .onSuccess { response ->
                    sharedPreferences.edit() {
                        putInt("userId", response.userId)
                    }

                    clearData()
                    onSuccess()
                }
                .onFailure {
                    onFailure(it.message ?: "로그인에 실패했습니다.")
                }
        }
    }


    fun clearData() {
        _id.value = ""
        _password.value = ""
    }
}