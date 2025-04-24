package org.sopt.at.presentation.ui.signup

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.imePadding
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import org.sopt.at.R
import org.sopt.at.core.component.button.TvingSignButton
import org.sopt.at.core.component.topbar.BackButtonTopBar
import org.sopt.at.core.util.toast
import org.sopt.at.presentation.ui.signup.content.SignUpContent
import org.sopt.at.ui.theme.TvingTheme

@Composable
fun SignUpRoute(
    navigateToSignIn: () -> Unit,
    modifier: Modifier = Modifier,
    viewModel: SignUpViewModel = hiltViewModel()
) {
    val context = LocalContext.current
    val signUpState by viewModel.signUpState.collectAsStateWithLifecycle()
    val id by viewModel.id.collectAsStateWithLifecycle()
    val password by viewModel.password.collectAsStateWithLifecycle()

    SignUpScreen(
        signUpState = signUpState,
        id = id,
        onIdChange = viewModel::updateId,
        password = password,
        onPasswordChange = viewModel::updatePassword,
        onNextClick = {
            if (signUpState == 1) {
                if (!viewModel.isIdValid(id)) {
                    context.toast(R.string.sign_up_toast_id)
                } else {
                    viewModel.nextStep()
                }
            } else {
                if (!viewModel.isPasswordValid(password)) {
                    context.toast(R.string.sign_up_toast_password)
                } else {
                    viewModel.saveCredentials(context)
                    viewModel.clearData()
                    navigateToSignIn()
                }
            }
        },
        onBackClick = {
            if (signUpState == 1) {
                navigateToSignIn()
            } else {
                viewModel.previousStep()
            }
        },
        modifier = modifier
    )
}

@Composable
fun SignUpScreen(
    signUpState: Int,
    id: String,
    onIdChange: (String) -> Unit,
    password: String,
    onPasswordChange: (String) -> Unit,
    onNextClick: () -> Unit,
    onBackClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Scaffold(
        modifier = modifier
            .fillMaxSize()
            .imePadding(),
        topBar = {
            BackButtonTopBar(onBackClicked = onBackClick)
        },
        bottomBar = {
            TvingSignButton(
                label = stringResource(R.string.button_sign_up_next),
                onClick = onNextClick,
                isDisabled = when (signUpState) {
                    1 -> id.isBlank()
                    2 -> password.isBlank()
                    else -> true
                },
                modifier = Modifier.padding(20.dp)
            )
        }
    ) { innerPadding ->
        when (signUpState) {
            1 -> SignUpContent(
                type = stringResource(R.string.textfield_id),
                id = id,
                onIdChange = onIdChange,
                password = password,
                onPasswordChange = onPasswordChange,
                modifier = Modifier.padding(innerPadding)
            )

            2 -> SignUpContent(
                type = stringResource(R.string.textfield_password),
                id = id,
                onIdChange = onIdChange,
                password = password,
                onPasswordChange = onPasswordChange,
                modifier = Modifier.padding(innerPadding)
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewSignUpScreen() {
    TvingTheme {
        SignUpScreen(
            signUpState = 1,
            id = "",
            onIdChange = {},
            password = "",
            onNextClick = {},
            onBackClick = {},
            onPasswordChange = {}
        )
    }
}