package org.sopt.at.presentation.ui.signin

import android.content.Context
import android.content.SharedPreferences
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject

@HiltViewModel
class SignInViewModel @Inject constructor() : ViewModel() {
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

    fun clearData() {
        _id.value = ""
        _password.value = ""
    }

    fun isSignInAvailable(): Boolean {
        val savedId = sharedPreferences.getString("id", "")
        val savedPassword = sharedPreferences.getString("password", "")
        return _id.value == savedId && _password.value == savedPassword && _id.value.isNotEmpty() && _password.value.isNotEmpty()
    }
}