package org.sopt.at.presentation.ui.signup

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import org.sopt.at.R
import org.sopt.at.presentation.ui.signup.content.SignUpContent
import org.sopt.at.ui.theme.TvingTheme

@Composable
fun SignUpRoute(
    modifier: Modifier = Modifier,
    viewModel: SignUpViewModel = hiltViewModel()
) {
    val signUpState by viewModel.signUpState.collectAsStateWithLifecycle()
    val id by viewModel.id.collectAsStateWithLifecycle()
    val password by viewModel.password.collectAsStateWithLifecycle()

    SignUpScreen(
        signUpState = signUpState,
        id = id,
        onIdChange = viewModel::updateId,
        password = password,
        onPasswordChange = viewModel::updatePassword,
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
    modifier: Modifier = Modifier
) {

    when (signUpState) {
        1 -> SignUpContent(
            type = stringResource(R.string.textfield_id),
            id = id,
            onIdChange = onIdChange,
            password = password,
            onPasswordChange = onPasswordChange,
            modifier = modifier
        )

        2 -> SignUpContent(
            type = stringResource(R.string.textfield_password),
            id = id,
            onIdChange = onIdChange,
            password = password,
            onPasswordChange = onPasswordChange,
            modifier = modifier
        )
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
            onPasswordChange = {}
        )
    }
}