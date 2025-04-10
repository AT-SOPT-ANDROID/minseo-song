package org.sopt.at.presentation.ui.signup

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.imePadding
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import dagger.hilt.android.AndroidEntryPoint
import org.sopt.at.R
import org.sopt.at.core.component.button.TvingSignButton
import org.sopt.at.core.component.topbar.TvingTopBar
import org.sopt.at.core.util.toast
import org.sopt.at.presentation.ui.signin.ID_KEY
import org.sopt.at.presentation.ui.signin.PASSWORD_KEY
import org.sopt.at.ui.theme.TvingTheme

@AndroidEntryPoint
class SignUpActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val viewModel: SignUpViewModel = hiltViewModel()
            val signUpState by viewModel.signUpState.collectAsState()
            val id by viewModel.id.collectAsState()
            val password by viewModel.password.collectAsState()

            TvingTheme {
                Scaffold(
                    modifier = Modifier
                        .fillMaxSize()
                        .imePadding(),
                    topBar = {
                        TvingTopBar(
                            onBackClicked = {
                                if (signUpState == 1) finish()
                                else viewModel.previousStep()
                            }
                        )
                    },
                    bottomBar = {
                        TvingSignButton(
                            label = stringResource(R.string.button_sign_up_next),
                            onClick = {
                                if (signUpState == 1) {
                                    if (!viewModel.isIdValid(id)){
                                        toast(R.string.sign_up_toast_id)
                                        return@TvingSignButton
                                    }
                                    viewModel.nextStep()
                                } else {
                                    if (!viewModel.isPasswordValid(password)){
                                        toast(R.string.sign_up_toast_password)
                                        return@TvingSignButton
                                    }
                                    setResult(RESULT_OK, Intent().apply {
                                        putExtra(ID_KEY, id)
                                        putExtra(PASSWORD_KEY, password)
                                    })
                                    finish()
                                }
                            },
                            isDisabled = when (signUpState) {
                                1 -> id.isBlank()
                                2 -> password.isBlank()
                                else -> true
                            },
                            modifier = Modifier.padding(20.dp)
                        )
                    }
                ) { innerPadding ->
                    SignUpRoute(
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

