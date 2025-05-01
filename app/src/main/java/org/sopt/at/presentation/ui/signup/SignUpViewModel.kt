package org.sopt.at.presentation.ui.signup

import android.content.Context
import androidx.core.content.edit
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import org.sopt.at.core.util.KeyStorage
import javax.inject.Inject

@HiltViewModel
class SignUpViewModel @Inject constructor() : ViewModel() {
    private val _id = MutableStateFlow<String>("")
    val id = _id.asStateFlow()

    private val _password = MutableStateFlow<String>("")
    val password = _password.asStateFlow()

    private val _signUpState = MutableStateFlow<Int>(1)
    val signUpState = _signUpState.asStateFlow()

    fun updateId(newId: String) {
        _id.value = newId
    }

    fun updatePassword(newPassword: String) {
        _password.value = newPassword
    }

    fun nextStep() {
        if (_signUpState.value == 1) _signUpState.value = 2
    }

    fun previousStep() {
        if (_signUpState.value == 2) _signUpState.value = 1

    }

    fun isIdValid(id: String): Boolean {
        return KeyStorage.ID_REGEX.matches(id)
    }

    fun isPasswordValid(password: String): Boolean {
        return KeyStorage.PASSWORD_REGEX.matches(password)
    }

    fun saveCredentials(context: Context) {
        val prefs = context.getSharedPreferences("user_prefs", Context.MODE_PRIVATE)
        prefs.edit() {
            putString("id", id.value).putString("password", password.value)
        }
    }

    fun clearData() {
        _id.value = ""
        _password.value = ""
        _signUpState.value = 1
    }
}