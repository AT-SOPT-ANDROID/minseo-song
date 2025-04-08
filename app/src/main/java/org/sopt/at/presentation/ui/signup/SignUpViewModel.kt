package org.sopt.at.presentation.ui.signup

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject

@HiltViewModel
class SignUpViewModel @Inject constructor() : ViewModel() {
    private val _id = MutableStateFlow<String>("")
    val id: StateFlow<String> = _id.asStateFlow()

    private val _password = MutableStateFlow<String>("")
    val password: StateFlow<String> = _password.asStateFlow()

    private val _signUpState = MutableStateFlow<Int>(1)
    val signUpState: StateFlow<Int> = _signUpState.asStateFlow()

    fun updateId(newId: String) {
        _id.value = newId
    }

    fun updatePassword(newPassword: String) {
        _password.value = newPassword
    }

    fun nextStep(){
        if (_signUpState.value == 1) _signUpState.value = 2
    }

    fun previousStep(){
        if (_signUpState.value == 2) _signUpState.value = 1

    }

    fun isIdValid(id: String): Boolean {
        val regex = Regex("^[a-z0-9]{6,12}$")
        return regex.matches(id)
    }

    fun isPasswordValid(password: String): Boolean {
        val regex = Regex("^(?=.*[a-zA-Z])(?=.*\\d)(?=.*[~!@#\$%^&*])[a-zA-Z\\d~!@#\$%^&*]{8,15}$")
        return regex.matches(password)
    }
}